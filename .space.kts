/**
* JetBrains Space Automation
* This Kotlin-script file lets you automate build activities
* For more info, see https://www.jetbrains.com/help/space/automation.html
*/

job("Pulumi preview") {
    startOn {
        gitPush { enabled = true }
    }
    container(displayName = "Python Pulumi", image = "pulumi/pulumi-python") {
     	env["PULUMI_ACCESS_TOKEN"] = Secrets("pulumi_access_token")
         
        //  shellScript {
        // 	content = """
        //         cd python
        //     	python3 pip install -r requirements.txt
        //         pulumi login
        //         pulumi stack select dev
        //         pulumi preview
        //     """
        // } 

          shellScript {
        	content = """
                python --version
            """
        }     
    }
}
