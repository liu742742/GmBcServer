module.exports = [
  {
    "file": "../src/main/java/com/spider/website/spidercase/entity/SpiderAllocation.java",
    "replace": [
      {
        "regex": "(/\\*\\*phantomjs address\\*/)(.|\\n)*(/\\*phantomjs address\\*\\*/)",
        "content": "private static String phantomjsaddress=Thread.currentThread().getContextClassLoader().getResource(\"\").getPath()+\"com/spider/driver/phantomjs.exe\";"
      }
    ]
  },
  {
    "file": "../pom.xml",
    "replace": [
      {
        "regex": "(<\\!--\\* tomcat configuration -->)(.|\\n)*(<\\!-- tomcat configuration \\*-->)",
        "content": "<url>http://localhost:8080/manager/text</url><username>tomcat</username><password>tomcat</password><server>a2d</server>"
      }
    ]  
  }
]