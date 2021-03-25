<template>
<div class="SearchView">
    <img alt="PaperRetriveal logo" src="../assets/PaperRetriveal.png" class="logo" >
    <!-- <div><el-input v-model="input" placeholder="支持关键字、论文编号检索" id="seachBox"></el-input>
        <el-button type="primary">主要按钮</el-button>
    </div> -->
    <el-row>
        <el-col :span="7"><div ></div></el-col>
        <el-col :span="8"><div class="grid-content bg-purple">
            <el-input v-model="input" placeholder="支持关键字、论文编号检索" id="seachBox"></el-input>
            </div></el-col>
        <el-col :span="4"><div class="grid-content bg-purple-light"></div></el-col>
        <el-col :span="5"><div class="grid-content bg-purple"></div></el-col>
    </el-row>  
</div>
</template>
<style>
.logo{
    width: 560px;
    height: 80px;
    margin-top:80px;
    margin-bottom:20px;
}
#seachBox{
    width: 500px;
    height:46px;
    display:inline;
}
</style>