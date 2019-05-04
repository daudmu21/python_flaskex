node{
    properties([parameters([string(defaultValue: 'IP', description: 'where to build e.g IP', name: 'ENV'"", trim: true)])])
    stage("clone repo"){
        git 'git@github.com:daudmu21/Flaskex.git'
    }
    stage ("Build application"){
        sh "scp-r * ssh ec2-user@${ENV}:/tmp"
        sh "ssh ec2-user@${ENV} pip install -r /tmp/requirements.txt"
    }
    stage("App Run"){
        sh "ssh ec2-user@${ENV} python /tmp/app.py"
    }
}