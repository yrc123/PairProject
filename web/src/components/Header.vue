<template>
<div class="header">
  <div class="header-bar">
      <el-tooltip class="item" effect="dark" content="查看最热门的10个领域" placement="bottom-end" >
        <el-link :underline="false" class="header-font" style="margin-right:60px">热门领域</el-link>
      </el-tooltip>
      <el-tooltip class="item" effect="dark" content="直接从爬取的最新论文库中搜索" placement="bottom-end" >
        <el-link :underline="false" class="header-font">最新论文库</el-link>
      </el-tooltip>
  </div>

</div>
</template>

<style>
  .header-font{
      line-height: 30px;
  }
  .header{
      margin-top:16px;
      display:flex;
      flex-direction:row-reverse;

  }

  .header-bar{
    height: 40px;
    display: flex;
    width: fit-content;
    flex-direction: unset;
    margin-right: 16%;
  }
</style>  