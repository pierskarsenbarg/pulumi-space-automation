/**
* JetBrains Space Automation
* This Kotlin-script file lets you automate build activities
* For more info, see https://www.jetbrains.com/help/space/automation.html
*/

job("Pulumi preview") {
    container(displayName = "Pulumi", image = "pulumi/pulumi") {
     	shellScript {
        	content = """
            	npm ci
                pulumi login
                pulumi preview
            """
        }   
    }
}
