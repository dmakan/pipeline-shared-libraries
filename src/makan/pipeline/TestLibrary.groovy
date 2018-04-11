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
            return 'error1'
        }

        //return fileContent

        if (fileContent != null && !fileContent.empty) {
            //return 'errorX0'

            //echo "fileContent: $fileContent"

            fileContent.splitEachLine('=') { items ->
                def pom0 = items[0]
                def pom1 = items[1]
                //echo "oneLine: $pom0 : $pom1"

                echo "$pom0".equals("version")

                if("$pom0".equals("version")) {
                    return "$pom1"
                }
            }


            /*Arrays.asList(fileContent.split('\n')).each {
                return 'errorX1'
                try {
                    return (it =~ /^\s*?version\s*?=\s*?(\d+\.\d+\.\d+-.?)/)[0][1]
                } catch (IndexOutOfBoundsException e) {
                    return 'error2'
                }
            }**/
        }

        return 'error3'
    }
}
