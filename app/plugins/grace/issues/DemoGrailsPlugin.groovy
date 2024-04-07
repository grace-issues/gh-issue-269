package grace.issues

import grails.plugins.*

class DemoGrailsPlugin extends Plugin {

    def grailsVersion = "2022.0.0 > *"
    def version = "1.0.0"

    Closure doWithSpring() { {->
            Properties properties = loadProperties()
            println properties
        }
    }

    def loadProperties() {
        Properties properties = new Properties()
        if (config.containsKey('demo')) {
            ConfigObject configObject = new ConfigObject()
            configObject.putAll(config.demo)
            properties << configObject.toProperties('thiz.demo')
        }
        properties
    }

}
