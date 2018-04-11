package makan.pipeline

import java.nio.file.NoSuchFileException;

class TestLibrary extends AbstractLibrary {
    private static final String PROPERTY_FILE = 'test.properties'

    TestLibrary(final script, final steps) {
        super(script, steps)
    }

    String method1() {
        final String fileContent = ''

        try {
            fileContent = steps.readFile encoding: 'UTF-8', file: PROPERTY_FILE
        } catch (NoSuchFileException e) {
            return 'error1'
        }

        if (fileContent != null && fileContent.empty) {
            Arrays.asList(fileContent.split('\n')).each {
                try {
                    return (it =~ /^\s*?version\s*?=\s*?(\d+\.\d+\.\d+-.?)/)[0][1]
                } catch (IndexOutOfBoundsException e) {
                    return 'error2'
                }
            }
        }

        return 'error3'
    }
}
