module.exports = [
  {
    "file": "../src/main/java/com/spider/website/spidercase/entity/SpiderAllocation.java",
    "replace": [
      {
        "regex": "(/\\*\\*phantomjs address\\*/)(.|\\n)*(/\\*phantomjs address\\*\\*/)",
        "content": "private static String phantomjsaddress=\"/usr/bin/phantomjs\";"
      }
    ]  
  },
  {
    "file": "../pom.xml",
    "replace": [
      {
        "regex": "(<\\!--\\* tomcat configuration -->)(.|\\n)*(<\\!-- tomcat configuration \\*-->)",
        "content": "<url>http://115.233.227.46:7008/manager/text</url><username>admin</username><password>admin</password><server>tomcat8</server>"
      }
    ]  
  }
]