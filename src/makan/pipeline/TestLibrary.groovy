package makan.pipeline

import java.nio.file.NoSuchFileException;

class TestLibrary extends AbstractLibrary implements Serializable {
    private static final String PROPERTY_FILE = 'test.properties'

    TestLibrary(final script, final steps) {
        super(script, steps)
    }

    String method1() {
        final String fileContent = ''

        try {
            fileContent = steps.readFile encoding: 'UTF-8', file: PROPERTY_FILE
        } catch (NoSuchFileException e) {
            return 'NoSuchFileException'
        }

        if (fileContent != null && !fileContent.empty) {
            fileContent.splitEachLine('=') { items ->
                def key = items[0]
                def value = items[1]

                if("$items[0]".equalsIgnoreCase('version')) {
                    return "$value"
                }
            }
        } else {
            return ''
        }
    }
}
