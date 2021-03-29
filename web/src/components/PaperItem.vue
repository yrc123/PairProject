<template>
<div>
    <div style="border: 1px solid;display:flex;height:170px;flex-direction:column;">
        <span class="paper-title">The Cascade-Correlation Learning Architecture</span>
        <span class="abstract">
            <div class="abstract-label">摘要：</div>
            <span class="abstract-content">Cascade-Correlation is a new architecture and supervised learning algorithm for artificial neural networks. Instead of just adjusting the weights in a network of fixed topology...</span>
        </span>
    </div>
</div>
</template>
<style>
.paper-title{
    font-size:20px;
    font-weight:520;
    color:#0066CC;
    display:inline-flex;
}
.paper-title:hover{
    text-decoration:underline;
}
.abstract{
    display:block;
    width:600px;
    height:38px;
    overflow: hidden;
    font-family:Microsoft YaHei;
    font-size:0px;
    text-overflow: ellipsis;
    white-space:pre-wrap;
    text-align:left;
    
}
.abstract-label{
    font-size:14px;
    color: #7F7F7F;
    display:inline;
    height:inherit;
}
.abstract-content{
    font-size:14px;
    height:100%;
    overflow: hidden;
    font-family:Microsoft YaHei;
}
</style>