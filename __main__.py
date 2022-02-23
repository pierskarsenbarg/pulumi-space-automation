"""A Google Cloud Python Pulumi program"""

import pulumi
import pulumi_random

password = pulumi_random.RandomPassword("pw",
                                        length=20
                                        )

pulumi.export("pw", password.result)
