# cPanel API
___
### 1. Local Setup:
1. Configure Git local installation with ssh key: [Tutorial](https://medium.com/devops-with-valentine/2021-how-to-set-up-your-ssh-key-for-github-on-windows-10-afe6e729a3c0).
2. Clone this repo in any local folder:
```$ git clone git@github.com:danrprado/cpanel-api.git```
3. Inside of the project folder (cpanel-api):
   - Create a custom branch with: 
   ```$ git checkout -b mynewbranch  ```
   - Now you're working inside of [**mynewbranch**] branch, test it with: ```$ git branch```.

Now you can start to make changes in your local repository with your favorite IDE!

**Remember to push to [*mynewbranch*]: ```$ git push -u origin mynewbranch``` **and create a Pull Request** to merge [*mynewbranch*] with [*main*] branch.
___
### 2. DB Connection:
1. Create a new file named: ```application-dev.properties``` in ```/src/main/resources/``` and copy all the content of ```application.properties```.
2. Modify the field: ```aws.profile.name``` and add your aws cli profile name. (*Optional but highly recommended: Install the AWS Toolbox plugin for IntelliJ, from the UI you can modify or check your aws cli profiles*).
3. Edit the run configuration of your local project: ![](https://i.imgur.com/bDPtsWy.png)
4. Run the project and test any endpoint in your localhost url, now your local application retrieve programmatically the database credentials stored in AWS Parameter Store, so, no hardcoded credentials :)