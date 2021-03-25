<template>
<div class="header">
<el-row>
  <el-col :span="16"><div></div></el-col>
  <el-col :span="2"><div>
    <el-tooltip class="item" effect="dark" content="查看最热门的10个领域" placement="bottom-end" >
      <el-link :underline="false" class="header-font">热门领域</el-link>
    </el-tooltip>
      </div></el-col>
  <el-col :span="2"><div>
    <el-tooltip class="item" effect="dark" content="直接从爬取的最新论文库中搜索" placement="bottom-end" >
      <el-link :underline="false" class="header-font">最新论文库</el-link>
    </el-tooltip>
      </div></el-col>
  <el-col :span="2"><div ></div></el-col>
  <el-col :span="2"><div></div></el-col>
</el-row>
</div>
</template>

<style>
  .el-row {
    margin-bottom: 20px;
    &:last-child {
      margin-bottom: 0;
    }
  }
  .el-col {
    border-radius: 4px;
  }
  .bg-purple-dark {
    background: #99a9bf;
  }
  .bg-purple {
    background: #d3dce6;
  }
  .bg-purple-light {
    background: #e5e9f2;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
  .row-bg {
    padding: 10px 0;
    background-color: #f9fafc;
  }
  .header-font{
      line-height: 30px;
  }
  .header{
      margin-top:16px;
  }

</style>