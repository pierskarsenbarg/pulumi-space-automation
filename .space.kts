job("Create password") {
    startOn {
        gitPush { enabled = true }
    }
    container(displayName = "Run Pulumi", image = "pulumi/pulumi-python") {
     	env["PULUMI_ACCESS_TOKEN"] = Secrets("pulumi_access_token")
         
         shellScript {
            interpreter = "/bin/bash"
        	content = """
                python -m venv venv
                source venv/bin/activate
            	pip install -r requirements.txt
                pulumi login
                pulumi stack select dev
                pulumi up -y

                echo 'Password value:'
                pulumi stack output pw --show-secrets

                pulumi destroy -y
            """
        }    
    }
}
