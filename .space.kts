/**
* JetBrains Space Automation
* This Kotlin-script file lets you automate build activities
* For more info, see https://www.jetbrains.com/help/space/automation.html
*/

job("Pulumi preview") {
    startOn {
        gitPush { enabled = true }
    }
    container(displayName = "Python Pulumi", image = "pulumi/pulumi") {
     	shellScript {
        	content = """
                cd python
            	python pip install -r requirements.txt
                source venv/bin/activate
                pulumi login
                pulumi preview
            """
        }   
    }
}
