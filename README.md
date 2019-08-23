## 欢迎访问连营电子文件系统源代码资源库！
### Welcome to visit source of uetec-file-system!

_当前版本：v1.0.20-RELEASE_

### 简介
_uetec-file-system——一款便捷、开源、功能完善的个人&团队&小型团队网盘服务器系统。

_uetec-file-system能够帮助您快速搭建起一个面向家庭、团队或组织的网盘系统，它操作简单、高效且功能多样。这里是uetec-file-system的源代码资源库，您可以在这里获得uetec-file-system的源代码，并对其进行下载、阅读与重构。

注：如果您仅仅希望得到一份拿来即用的软件，uetec-file-system也提供了一个完整的、解压即用的编译版。您可以根据其说明在3分钟内快速安装并开始使用。如果您需要该版本，请转到以下位置进行浏览和下载：
[uetec-file-system-官方主页](https://kohgylw.gitee.io)

### 构建说明
_下列条目为uetec-file-system开发环境的基本信息，如需对源代码进行查看及编译，推荐使用所列配置。_
+ JDK版本：1.8.0_131
+ 项目管理框架：Maven（m2e 1.8.0 for Eclipse）,Archetype：mavem-archetype-quickstart 1.1。
+ 编码格式：UTF-8
+ 项目资源及配置：Spring Boot+MyBatis+H2 DB，详见pom.xml文档。

### 快速开始
+ 使用Eclipse(javaEE)以项目方式导入本资源文件夹，并设置构建路径中的JDK版本。
+ 使用Maven选项更新项目，并确保pom文件中引入的所有外部资源能够正确引入至本地。
+ 打开uetec.filesystem.mc.MC类，进行测试运行。
+ 右键项目，执行Run with选项中的Maven install操作以在target文件夹内编译生成jar程序。
+ 将生成的jar程序拷贝到项目主目录下（即与libs等文件夹同级）并开始使用。

_提示：源代码路径下包含了一些程序运行所需的非源代码资源（例如程序图标等），某些集成式开发环境（例如IDEA）在编译过程中可能会自动忽略非源代码资源。您需要设置并保证这些资源也能够被正确打包至最终的jar程序内，否则将会导致编译出的程序无法顺利运行。_

### 程序基本结构说明
+ 源代码资源文件夹：/src/main/java/
+ 入口类：uetec.filesystem.mc.MC
+ web界面请求处理包：uetec.filesystem.server.controller、uetec.filesystem.server.filter
+ web界面操作逻辑包：uetec.filesystem.server.service
+ 核心功能及文件系统实现包：kohgylw.server.util、uetec.filesystem.server.listener、uetec.filesystem.server.mapper、uetec.filesystem.server.model
+ 服务器行为控制类：kohgylw.server.ctl.KiftdCtl
+ 服务器界面相关包：uetec.filesystem.ui、uetec.filesystem.printer
+ 独立文件管理模块相关包：uetec.filesystem.util.file_system_manager
+ 第三方工具使用许可证包：uetec.filesystem.util.licenses
+ web页面静态资源文件夹：/webContext/
+ mybatis映射表文件夹：/mybatisResource/
+ 外部引用资源（编译后生成）文件夹：/libs/
+ 引用字体文件夹：/fonts/
+ 设置文件（程序第一次运行后生成）文件夹：/conf/
+ 日志文件夹：/logs/
+ 编译输出文件夹：/target/
+ maven配置文件：/pom.xml

### 常见问题&解决方案
+ 更换更高版本的Spring Boot后无法启动项目
> 如果您需要将uetec-file-system所用的Spring Boot版本替换至更高（尤其是Spring Boot 2.0.4及以上版本），请重写源代码`uetec.filesystem.server.configation.MVC`类中的`afterPropertiesSet()`方法，并将其方法体留空。否则可能导致项目启动错误（特别鸣谢：用户 songdragon）。

+ 启动源代码项目时出现“Error creating bean with name org.mybatis.spring.mapper.MapperScannerConfigurer”
> 如遇该问题，请尝试将pom.xml文件中引入的`mybatis`资源和`mybatis-spring`资源移除并重新添加`mybatis-spring-boot-starter`资源，从而避免默认整合方式可能导致的Spring Boot框架插件兼容性问题（特别鸣谢：用户 michael）。

### 使用许可（下载该源代码资源即视为接受以下许可）
当前版本的uetec-file-system使用自带的许可文件进行分发。您应该先阅读该文件（获取方式：前往uetec-file-system发行版主页下载一份uetec-file-system发行版并在其中获得，详见 https://github.com/KOHGYLW/uetec-file-system ），并在同意其中的所有条款后再下载该源代码。其大致内容如下：

+ 您可以免费获得该源代码的原版拷贝。
+ 您可以自由地对该源代码进行分发、重构并运用于任何领域。
+ 作者对于使用该源代码造成的任何后果均无需负责。
+ 作者对该源代码具有版权。

### 关于该源代码...
该源代码为目前发布的uetec-file-system解压即用版的原始编译来源，二者保持一致性（有时源码版本可能会略微超前），作者将在今后对其逐步进行整理以便于用户阅读，由此带来的不便敬请谅解。

### 联系作者？
如有任何需要（例如对该资源有疑问、意见或建议），请发件联系作者： yukai.guo@uetec.cn （要么出众，要么出局），随时恭候您的来信！

yukai.guo@uetec.cn by 2019年8月17日

