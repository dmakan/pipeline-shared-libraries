package makan.pipeline;

abstract class AbstractLibrary {
    def script
    def steps

    AbstractLibrary(final script, final steps) {
        this.script = script
        this.steps = steps
    }
}
