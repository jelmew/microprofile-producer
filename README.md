#Readme
Specs
-
* Create an UberJar to deploy on Minishift
* Use MicroProfile 


#Howto
* Create a build config from binary. 
`oc new-build redhat-openjdk18-openshift:1.2  --name=microprofile-producer --strategy=source --binary`
* Kick the build for the new jar
`oc start-build microprofile-producer --from-file=target/microprofile-producer-thorntail.jar -F`
* Start the app
`oc new-app microprofile-producer`
* Expose using
`oc expose service/microprofile-producer`
* View the route using
`oc get route microprofile-producer`
* Retrigger builds
` mvn clean package && oc start-build microprofile-producer --from-file=target/microprofile-producer-thorntail.jar -F`

#Reference
[openshift java s2i java 11 builder](https://developers.redhat.com/blog/2018/12/18/openshift-java-s2i-builder-java-11-grade/)
[Running java 11 on openshift](https://access.redhat.com/errata/RHEA-2019:0282)
[Binary builds](https://github.com/openshift-evangelists/openshift-cookbook/issues/1)
[Openshift pipeline](https://github.com/openshift/origin/tree/master/examples/jenkins/pipeline)
[Decreasing run time using caching](https://blog.openshift.com/decrease-maven-build-times-openshift-pipelines-using-persistent-volume-claim/)