<template>
<div class="SearchView">
    <img alt="PaperRetriveal logo" src="../assets/PaperRetriveal.png" class="logo" >
    <!-- <div><el-input v-model="input" placeholder="支持关键字、论文编号检索" id="seachBox"></el-input>
        <el-button type="primary">主要按钮</el-button>
    </div> -->
    <div style="height:50px;">
        <el-input v-model="input" placeholder="支持关键字、论文编号检索" id="seachBox" style="width:500px;height:100%;"></el-input>
        <el-button type="primary" style="height:100%">论文检索</el-button>
    </div>
    
</div>
</template>
<style>
.logo{
    width: 520px;
    height: 70px;
    margin-top:80px;
    margin-bottom:30px;
}
#seachBox{
    height:100%;
    display:inline;
}
</style>