job("Pulumi preview") {
    startOn {
        gitPush { enabled = true }
    }
    container(displayName = "Python Pulumi", image = "pulumi/pulumi-python") {
     	env["PULUMI_ACCESS_TOKEN"] = Secrets("pulumi_access_token")
         
         shellScript {
            interpreter = "/bin/bash"
        	content = """
                cd python
                python -m venv venv
                source venv/bin/activate
            	pip install -r requirements.txt
                pulumi login
                pulumi stack select dev
                pulumi preview
            """
        }    
    }
}
