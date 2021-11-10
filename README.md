Pre-requisites:

1. Import this project into your Eclipse or STS.
2. Put the file logfile.txt in your local system which will have server log information and will be parsed. logfile.txt will have array of json objects. Sample file is included here.
3. Build the project using 'Maven clean' and 'Maven install' commands.
    3.a. Right click on pom.xml
    3.b. Select 'Run As -> Maven clean'. Build should be successful.
    3.c. Select 'Run As -> Maven install'. Build should be successful.
4. Run the application.
    Since objective of this code to get the filename from command line, we will tell our IDE to consider the filename from command line. Process is as follows:
    4.a. Right click on project folder
    4.b. Select 'Run As -> Run Configurations'
    4.c. Click on 'Java Application' and create new configuration (Right Click on 'Java Application') from the left side menu from the the window that just opened.
    4.d. Select Main class of the project in 'Main' tab. [com.suisse.credit.Driver.App] in this case .
    4.e. Now click on 'Arguements' tab and paste the path of the file from your local system [logfile.txt, which needs to be parsed] in 'Program Arguements' textbox.
    4.f. Click Apply and Run.
    
 Application will run and save the data as required.
 
