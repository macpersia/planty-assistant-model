//pipeline {
//    agent any
//    tools {
//        maven 'apache-maven-3.6.0'
//        jdk 'jdk8'
//    }
//    script {
//	    def branch = "${env.BRANCH_NAME}".toLowerCase()
node {
    def branch = "${env.BRANCH_NAME}".toLowerCase()
    stage('git') {
		/* Changed due to a bug: "${scmBranch} is returning UNKNOW"
		 * (https://github.com/mojohaus/buildnumber-maven-plugin/issues/53#issuecomment-373110568) */
		//checkout scm
		//def jobName = "${env.JOB_NAME}"
		//def repoPath = jobName.substring(0, jobName.lastIndexOf('/'))
		git url: "https://macpersia@bitbucket.org/planty-assistant-devs/planty-assistant-model.git", branch: branch
	}
	
	stage('build4mvn') {
		withMaven(jdk: 'jdk-8', maven: 'maven-3.6.0', /*, tempBinDir: ''*/) {
			sh "mvn install -DskipTests"
		}
	}

	stage('build4npm') {
		nodejs(nodeJSInstallationName: 'nodejs-10.14.2') {
            withNPM(npmrcConfig: 'my-npmrc') {
                sh "npm install"
                sh "npm run build"
                sh "cp package.json lib/"
                sh "npm pack lib/"
                sh "npm publish --registry http://repo-nexus-service:8081/repository/npm-local/"
            }
		}
	}
}

