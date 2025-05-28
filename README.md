# 🤬 华农 IMIS 限定版：学生管理屎山系统

[![GitHub license](https://img.shields.io/badge/license-祖传代码-red.svg)](https://github.com/SCAU-IMIS/ShitMountain) [![GitHub stars](https://img.shields.io/github/stars/SCAU-IMIS/ShitMountain)](https://github.com/SCAU-IMIS/ShitMountain/stargazers) [![GitHub issues](https://img.shields.io/github/issues/SCAU-IMIS/ShitMountain)](https://github.com/SCAU-IMIS/ShitMountain/issues)

> "紫荆桥下写 bug，芷园饭里找需求，校巴车上改文档" —— IMIS 学子三大人生阶段  

欢迎来到这个 SCAU IMIS 特供项目！完美诠释了咱们专业的终极奥义：

- **代码水平**：停留在"Hello World"
- **管理能力**：仅限于管理自己的头发
- **综合实力**：在泰山区和启林区间反复横跳

特别致敬：

- 那些在《数据库原理》和《管理信息系统》间精分的同学
- 在华山宿舍深夜 debug 的秃头战士
- 在图书馆抢不到座位只能在树木园写代码的狠人

## 💩 技术"栈"（学院 2020 年教学大纲限定版）

 [![Vue](https://img.shields.io/badge/Vue-3.4.15-brightgreen)](https://vuejs.org/) [![Spring Boot](https://img.shields.io/badge/Spring%20Boot-祖传版本-yellowgreen)](https://spring.io/) [![MySQL](https://img.shields.io/badge/MySQL-密码裸奔-red)](https://www.mysql.com/)

- **前端**：

  - Vue3（老师：我们教 jQuery 就够了）
  - TypeScript（教务系统都跑不明白的类型检查）
  - Vite（比你在华山宿舍抢热水还快的热更新）

- **后端**：
  - Spring Boot（Java 课设的棺材板）
  - Maven（依赖下载速度堪比启林南校网）

## 💣 祖传屎山解剖报告（心理承受力弱者慎入）

### 1. 安全？不存在的

```yaml
password:  # 写在配置文件里，黑客直呼"感谢老铁送的数据库"
```

比把校园卡密码写在卡上还蠢，安全意识堪比在华山宿舍不锁门

### 2. 代码质量惨绝人寰

```ts
export interface Result {
  code: boolean; // true=成功？false=失败？比高数及格线还模糊
  msg: string; // 错误信息比行政楼回复还敷衍
}
```

接口设计理念：能用就行，管他娘的用户体验

### 3. 精分功能缝合怪

```bash
springboot/src/main/resources/test/1/1.in
springboot/src/main/resources/test/1/1.out
```

迷惑行为大赏：

- 学生管理系统里塞 OJ 判题功能？
- 测试数据比高数试卷还难懂
- 资源路径像行政楼办事一样混乱

### 4. 前端行为艺术大赏

```json
"devDependencies": {
  "unocss": "^0.58.3"  // 安装后从未使用，纯属行为艺术
}
```

> 前端开发心路历程：
>
> 1. 跟风安装Unocss（然后完全不会用）
> 2. 抄袭别人Demo（然后看不懂）
> 3. 在屎山上疯狂叠代码（直到项目崩溃）
> 效果堪比在华山湖划船——原地打转

### 5. 屎山叠叠乐开发哲学

| 模块    | 真实作用                  | 开发动机          |
|---------|--------------------------|------------------|
| OJ      | 给另一个项目当垫脚石      | "能跑就行"       |
| Comment | 收集重构时的脏话素材      | "反正不是我用"   |
| SSE     | 让校巴永远不到站的诅咒    | "deadline驱动"  |

> 开发准则：
>
> 1. 绝不重构（紫荆桥塌了都不重构）
> 2. 能抄就抄（树木园芒果熟了都要抄）
> 3. 在屎山上拉新屎（直到成为珠穆朗玛屎峰）

## ☠️ 安装指南（IMIS 生存手册） [![Build Status](https://img.shields.io/badge/build-经常失败-red)](https://github.com/SCAU-IMIS/ShitMountain/actions) [![Coverage](https://img.shields.io/badge/coverage-0%25-lightgrey)](https://github.com/SCAU-IMIS/ShitMountain/actions)

### 1. 后端配置（教你认清现实）

```bash
./mvnw clean install
# 等待时间足够你：
# - 去教三捡一次芒果
# - 围观行政楼前领导合影
# - 听半场"丁颖精神"讲座
```

### 2. 前端配置（前端？不存在的）

```bash
npm install
# 建议在泰山区进行
# 启林北的网速会让你体会到什么叫绝望
```

## 🧩 项目结构（IMIS 课程表即视感）

```bash
├── springboot/             # 《JavaEE开发》课设尸体
│   └── src/main/resources/test/ # 教务系统祖传测试数据
│       ├── 1/              # 第1次重修的作业
│       ├── 2/              # 第2次重修的作业
│       └── ...             # 无限循环直到毕业
│
└── vue/                    # 《Web开发》最后的倔强
    └── login/              # 登录界面比芷园饭卡系统好看点
        ├── src/views/
        │   ├── student/    # 查成绩时发现59.5的悲痛
        │   ├── teacher/    # 录完成绩还要写教学评估的地狱
        │   └── manager/    # 只有课设答辩才存在的虚拟角色
```

## 💀 华农 IMIS 专属"特性"

- **教务系统级用户体验**：
  - 查成绩必崩（还原真实场景）
  - 选课排队动画（实际在空转）
- **特色模块**：
  - 早八点自动崩溃（致敬早课制度）
  - 丁颖像视线检测（专注超 5 分钟触发警报）
- **IMIS 经典场景**：

  ```java
  if(要写代码 && 要写文档){
      精神分裂();
  }else{
      延期毕业();
  }
  ```

## 💧 作者含泪补写的救命教程（必看）
>
> 历经 72 小时 debug，摔了 3 个键盘后总结的保命指南  
> 按步骤操作可减少 99% 的"我电脑上好好的"玄学问题

### 前端启动（Vue3版）

```bash
# 步骤 1：进坟墓
cd vue

# 步骤 2：下载祖传依赖（耗时≈等校巴）
npm i

# 步骤 3：启动前端（比行政楼办事快点儿）
npm run dev
```

⚠️ **致命陷阱**：  
打开`vue/src/api/config.ts`修改`baseURL`值：

```ts
// 本地运行用这个
baseURL: 'http://localhost:8080' 

// 线上部署用这个（别问我为啥是8080，祖传端口！）
// baseURL: 'https://your-production-url.com'
```

### 后端启动（Spring Boot版）

```bash
# 步骤 1：用IDEA打开`springboot`文件夹（版本必须≥2023，否则报错玄学）
# 步骤 2：修改数据库密码（位置：src/main/resources/application.yaml）

# 原始配置（等着被黑）：
password: 

# 正确配置（把'你的密码'换成实际密码）：
password: 你的密码 # 别学我裸奔！
```

🚨 **启动警告**：  
首次运行请右键点击`pom.xml` > "Maven" > "Reload Project"，  
否则依赖错误堪比行政楼盖章流程！

### 数据库初始化

```sql
-- 步骤 1：打开MySQL（版本必须=8.0，其他版本表结构会炸）
-- 步骤 2：执行根目录`data.sql`（效果≈在华山宿舍放蟑螂）
```

### 避坑指南

| 错误现象                  | 解决方案                  | 暴躁指数 |
|---------------------------|---------------------------|----------|
| 前端白屏                  | 检查`baseURL`+重启dev     | 🤬🤬🤬🤬 |
| 数据库连不上              | 删`target`文件夹+重启IDEA | 🤬🤬🤬   |
| 端口8080被占             | `netstat -ano`找进程杀掉  | 🤬🤬     |
| 依赖下载卡住              | 换清华镜像源              | 🤬       |

> 温馨提示：遇到问题先深呼吸，默念三遍"IMIS人永不认输"

### 模块说明书

| 模块    | 作用                  | 完成度 | 服务对象          |
|---------|-----------------------|--------|------------------|
| OJ      | 提供判题服务          | 60%    | 另一个前端项目    |
| Comment | 收集留言功能          | 30%    | 另一个前端项目    |
| SSE     | 实时消息推送          | 50%    | 另一个前端项目    |
| 文章审核| 鸽了（作者去芷园干饭）| 0%     | 本项目(未实现)    |

## ⚠️ 免责声明（必读）
>
> 本项目是IMIS学子精神污染源，含以下危险内容：
>
> - 祖传屎山代码（2003级学长传承）
> - 未实现接口（比行政楼办事效率还低）
> - 神秘测试数据（可能是选课系统彩蛋）
>
> 欢迎勇士联系我重构：
> ![联系二维码](https://github.com/HYH0309/student-manage-system/blob/main/QQ.jpg?raw=true)
>
> **最后声明**：这破项目就是一坨屎💩，赶紧跑路保平安！

## ⚰️ 特别鸣谢（没有你们就没有这个垃圾）

- **测试团队**：华山宿舍的蟑螂军团
- **营养支持**：芷园 3 元盖浇饭、西园奶茶
- **压力测试**：行政楼办事流程、校巴生死时速
- **代码评审**：树木园的蚊子（用生命在 review）
- **特别贡献**：每年摘芒果摔断腿的勇士

> 温馨提示：赶紧转去软件工程吧，IMIS 的尽头是卖化肥！访问此项目前建议先到行政楼办理《精神损失赔偿申请表》🐶
>
> ## 贡献指南 [![PRs Welcome](https://img.shields.io/badge/PRs-不欢迎-red)](https://github.com/SCAU-IMIS/ShitMountain/pulls)
>
> 1. Fork 本仓库（如果你想不开）
> 2. 创建你的分支 (`git checkout -b feature/你的奇葩想法`)
> 3. 提交你的改动 (`git commit -m '增加更多bug'`)
> 4. 推送到远程分支 (`git push origin feature/你的奇葩想法`)
> 5. 发起 Pull Request（我们大概率不会看）
