import os



def deploy(git_dir,mvn_dir,package_path,deploy_path
           ,server_ip, user_name, password, tomcat_path):
    os.chdir(git_dir)
    os.system("git pull")
    os.chdir(mvn_dir)
    os.system("mvn clean package -Dmaven.test.skip=true")
    package_dir=os.path.dirname(package_path)
    package_name=os.path.basename(package_path)
    deploy_name=os.path.basename(deploy_path)
    os.chdir(package_dir)
    os.rename(package_name,deploy_name)
    package_path=os.path.join(package_dir,deploy_name)
    


if __name__=="__main__":
    test_config={
        "git_dir":r"E:\_Git\Integralmall",
        "mvn_dir":r"E:\_Git\Integralmall",
        "package_path":r"E:\_Git\Integralmall\web\target\doublev2v-integralmall-web.war",
        "deploy_path":"/home/doublevv/apps/tomcat8/\
webapps_doublev2v_app/integralmall.war",
        "server_ip":"122.112.15.152",
        "user_name":"doublevv",
        "password":"xzymmlbbzyy",
        "tomcat_path":"/home/doublevv/apps/tomcat8"
        }
    
    deploy(**test_config)
    
