package com.xiaozhi;

import com.xiaozhi.utils.MD5Util;
import com.xiaozhi.utils.MarkdownUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author xiaozhi
 * @description
 * @create 2021-07-2021/7/15 1:33
 */
@SpringBootTest
public class TestMarkdown {

//    @Test
//    public void Test1(){
//        String markdown = "# HTML\n" +
//                "\n" +
//                "## 0 - 标签语法\n" +
//                "\n" +
//                "```html\n" +
//                "<!--title标签里面写这个网页的标题-->\n" +
//                "标题小实验\n" +
//                "\n" +
//                "<!-- ①标签不能交叉嵌套 -->\n" +
//                "正确：<div><span>早安</span></div>\n" +
//                "错误：\n" +
//                "<hr />\n" +
//                "\n" +
//                "<!-- ②标签必须正确关闭 -->\n" +
//                "<!-- i.文本内容的标签： -->\n" +
//                "正确：<div>早安</div>\n" +
//                "错误：\n" +
//                "<hr />\n" +
//                "\n" +
//                "<!-- ii.没文本内容的标签： -->\n" +
//                "正确：<br />\n" +
//                "错误：\n" +
//                "<hr />\n" +
//                "\n" +
//                "<!-- ③属性必须值，属性值必须加引号 -->\n" +
//                "正确：<font color=\"blue\">早安，尚硅谷</font>\n" +
//                "错误：\n" +
//                "错误：\n" +
//                "<hr />\n" +
//                "\n" +
//                "<!-- ④注释不能嵌套 -->\n" +
//                "正确：<!-- 注释内容 --> <br/>\n" +
//                "错误：<!--<!--错误的注释-->-->\n" +
//                "<hr />\n" +
//                "```\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "## 1 - font标签\n" +
//                "\n" +
//                "```html\n" +
//                "<!--\n" +
//                "    font标签：修改字体\n" +
//                "        color属性修改字体颜色\n" +
//                "        size属性修改字体大小，7是最大的\n" +
//                "        face属性修改字体的样式\n" +
//                "-->\n" +
//                "    <font color=\"#00ffff\" size=\"7\" face=\"楷体\">智哥最帅</font>\n" +
//                "```\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "## 2 -  特殊字符\n" +
//                "\n" +
//                "```html\n" +
//                "<!--\n" +
//                "    特殊字符：想要将标签显示出来，所以就需要特殊字符来实现这一功能\n" +
//                "            特殊符号前面都要加&\n" +
//                "-->\n" +
//                "    &lt;br&gt;表示换行    <!--显示出来的内容就是<br>-->\n" +
//                "    <!--在html中单纯的空格或者tab键和回车键都只能是一个空格，如果需要显示多个空格就需要nbsp;符号去实现-->\n" +
//                "    我是一个&nbsp;&nbsp;&nbsp;&nbsp;tab键    <!--特殊符号表示的是四个空格-->\n" +
//                "\n" +
//                "    <!--\n" +
//                "        标题标签：类似world文档里面的标题\n" +
//                "        h1是最大的\n" +
//                "        h6是最小的\n" +
//                "    -->\n" +
//                "    <h1>标题</h1>\n" +
//                "    <h2>标题</h2>\n" +
//                "    <h3>标题</h3>\n" +
//                "    <h4>标题</h4>\n" +
//                "    <h5>标题</h5>\n" +
//                "    <h6>标题</h6>\n" +
//                "```\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "## 3 - 超链接\n" +
//                "\n" +
//                "```html\n" +
//                "<!--\n" +
//                "    超链接：a标签是超链接\n" +
//                "        href属性设置连接地址\n" +
//                "        target属性设置那个目标跳转\n" +
//                "            常用的参数:①_self：当前页面跳转\n" +
//                "                     ②_blank：打开新的页面跳转\n" +
//                "                     ③也可以往里面放入iframe窗口的名字，跳转到iframe窗口里面\n" +
//                "\t\t通过在href中赋值对应的标签的id值可以跳转到对应的标签所在的位置\n" +
//                "-->\n" +
//                "\n" +
//                "<a href=\"localhost:8080\" target=\"_blank\">跳转新的页面</a>     <!--打开新的页面跳转-->\n" +
//                "<br/>   <!--换行-->\n" +
//                "<a href=\"localhost:8080\" target=\"_self\">当前页面跳转</a>      <!--当前页面跳转-->\n" +
//                "<a href=\"#a\">跳转到对应id的标签</a>\n" +
//                "<br>\n" +
//                "<br>\n" +
//                "<br>\n" +
//                "<br>\n" +
//                "<br>\n" +
//                "<br>\n" +
//                "<br>\n" +
//                "<br>\n" +
//                "<br>\n" +
//                "<br>\n" +
//                "<br>\n" +
//                "<br>\n" +
//                "<br>\n" +
//                "<br>\n" +
//                "<br>\n" +
//                "<a id=\"a\" href=\"#\">a标签</a>\n" +
//                "```\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "## 4 -   img标签\n" +
//                "\n" +
//                "```html\n" +
//                "<!--\n" +
//                "    img标签(单标签)：在html页面上显示图片\n" +
//                "        src属性设置图片的路径\n" +
//                "        width设置图片的宽度\n" +
//                "        height设置图片的高度\n" +
//                "        border设置相框\n" +
//                "        alt设置当指定路径找不到图片的时候显示的内容\n" +
//                "\n" +
//                "    html中的路径\n" +
//                "        相对路径：\n" +
//                "            .       表示当前目录\n" +
//                "            ..      表示上一级目录\n" +
//                "            文件名   表示当前目录，相当于./，./可以省略\n" +
//                "        绝对路径：http:IP:part/工程名/资源路径\n" +
//                "        和java的绝对路径是不一样的\n" +
//                "-->\n" +
//                "\n" +
//                "<img src=\"../img/28.jpg\" width=\"250\" height=\"300\" border=\"1\" alt=\"找不到该照片\"/>\n" +
//                "<img src=\"../img/2.jpg\" width=\"250\" height=\"300\" border=\"1\"/>\n" +
//                "<img src=\"../img/3.jpg\" width=\"250\" height=\"300\" border=\"1\"/>\n" +
//                "<img src=\"../img/4.jpg\" width=\"250\" height=\"300\" border=\"1\"/>\n" +
//                "```\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "## 5 - 列表标签\n" +
//                "\n" +
//                "```html\n" +
//                "<!--\n" +
//                "    列表标签\n" +
//                "        ul标签(无序列表)：没序列号的列表\n" +
//                "            type属性可以除去列表前面的符号\n" +
//                "        ol标签(序列表)：序列号的列表\n" +
//                "-->\n" +
//                "<ul type=\"none\">\n" +
//                "    <li>小智</li>\n" +
//                "    <li>好</li>\n" +
//                "    <li>帅</li>\n" +
//                "    <li>哦</li>\n" +
//                "</ul>\n" +
//                "```\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "## 6 - 表格标签\n" +
//                "\n" +
//                "```html\n" +
//                "<!--\n" +
//                "    table   表格标签\n" +
//                "        width   设置表格的宽度\n" +
//                "        height  设置表格的高度\n" +
//                "        align   设置表格相对于页面的对齐方式\n" +
//                "            参数：居中center     右right      左left\n" +
//                "        border  给每个单元格添加边框\n" +
//                "        cellspacing 设置单元格和表格的间距\n" +
//                "    td  单元格标签\n" +
//                "        align\n" +
//                "        colspan属性：跨行\n" +
//                "        rowspan属性：跨列\n" +
//                "    tr  行标签\n" +
//                "    b   加粗标签\n" +
//                "    th  表头标签 -> 居中对齐，加粗\n" +
//                "\n" +
//                "\tcaption\n" +
//                "-->\n" +
//                "<table align=\"right\" width=\"500\" height=\"500\" border=\"1\" cellspacing=\"0\">\n" +
//                "\n" +
//                "    <tr align=\"center\">\n" +
//                "        <td><b>1.1</b></td>\n" +
//                "        <td >1.2</td>\n" +
//                "        <td>1.3</td>\n" +
//                "    </tr>\n" +
//                "\n" +
//                "    <tr align=\"center\">\n" +
//                "        <td>2.1</td>\n" +
//                "        <td>2.2</td>\n" +
//                "        <td>2.3</td>\n" +
//                "    </tr>\n" +
//                "    <tr align=\"center\">\n" +
//                "        <td>3.1</td>\n" +
//                "        <td>3.2</td>\n" +
//                "        <td>3.3</td>\n" +
//                "    </tr>\n" +
//                "    <tr>\n" +
//                "        <th>4.1</th>\n" +
//                "    </tr>\n" +
//                "</table>\n" +
//                "```\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "## 7 - 表格的跨行跨列\n" +
//                "\n" +
//                "```html\n" +
//                "<!--\n" +
//                "    td标签的两个属性的用法\n" +
//                "        跨行和跨列和Excel中的合并单元格类似\n" +
//                "        colspan属性：跨行，参数是要跨几个单元格\n" +
//                "        rowspan属性：跨列\n" +
//                "-->\n" +
//                "<table border=\"1\">\n" +
//                "    <tr>\n" +
//                "        <td colspan=\"2\">1.1</td>\n" +
//                "        <td>1.2</td>\n" +
//                "    </tr>\n" +
//                "    <tr>\n" +
//                "        <td rowspan=\"2\">2.1</td>\n" +
//                "        <td>2.2</td>\n" +
//                "        <td>2.3</td>\n" +
//                "    </tr>\n" +
//                "    <tr>\n" +
//                "        <td>3.1</td>\n" +
//                "        <td>3.2</td>\n" +
//                "    </tr>\n" +
//                "    <tr>\n" +
//                "        <td>4.1</td>\n" +
//                "        <td>4.2</td>\n" +
//                "        <td>4.3</td>\n" +
//                "    </tr>\n" +
//                "</table>\n" +
//                "```\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "\n" +
//                "\n";
//        System.out.println(MarkdownUtil.markdownToHtml(markdown));
//    }

//    @Test
//    public void Test3(){
//        String xiaozhi = MD5Util.encrypt("123456");
//        System.out.println(xiaozhi);
//    }

}
