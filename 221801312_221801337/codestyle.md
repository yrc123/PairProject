# 后端代码规范

`221801337`

- 缩进
  - 一个tab为4个空格
- 变量命名
  - 不用拼音
  - 使用小驼峰命名
  - 声明变量时一个变量一行

- 每行最多字符数
  - 按实际语句分割
- 行数最大行数
  - 按功能分割
  - 一般来说不超过50行
- 函数、类命名
  - 函数用小驼峰，类名用大驼峰
  - 接口实现类以Impl结尾
- 常量
  - 命名全大写
- 空行规则
  - 类内声明变量之间无空格
  - 方法之间有空格
- 注释规则
  - 方法内部单行注释，在被注释语句上方另起一行，使用//注释。
  - 使用中文注解
- 操作符前后空格
  - 均有空格



# 前端代码规范

`221801312`

主要来参考[Vue官方风格指南](https://vue3js.cn/docs/zh/style-guide/)、[JS代码规范](https://github.com/BingKui/javascript-zh)、[HTML代码规范](https://www.runoob.com/html/html5-syntax.html)

因为是第一次Vue实战，也是我个人第一次比较完整地开发一个前端项目，这次的有很多时候都是在比较紧急的情况下修复BUG，所以我可能有一些地方没有注意到代码风格的问题，因为这次项目我也注意到了前端代码规范的问题，希望在以后的项目中能够更加完善自己的编程风格。

#### 数组

* 使用字面语法创建数组

```javascript
//bad
const arr=new Array();
//good
const arr=[];
```

* 使用push方法赋值而不用直接赋值

```javascript
const arr=[];
//bad
arr[0]='123bad';
//good
arr.push('123good');
```

#### 箭头函数

* 使用匿名函数时，使用箭头函数

```javascript
//bad
[1,2,3].map(function(x){
    return ;
});
//good
[1,2,3],map((x)=>{
    return ;
});
```

### 模块

* 不用通配符导入

```javascript
//bad
import * from 'vue'
//good
import onMounted from 'vue'
```

* 将所有的导入语句放在非导入语句上

```javascript
//bad
import ref from 'vue'
const a=ref([]);
import onMounted from 'vue'
//good
import ref from 'vue'
import onMounted from 'vue'
const a=ref([]);
```



### HTML元素

关闭所有HTML元素

```html
<!--bad-->
<p>段落
<!--good-->
<p>段落</p>
```

### 属性

使用小写属性名

```html
<!--bad-->
<div CLASS="footer">
<!--good-->
<div class="footer">
```

### 图片

使用alt属性，当图片不能显示时代替图片显示

```html
<!--good-->
<img src="long.png" alt="Logo">
```

