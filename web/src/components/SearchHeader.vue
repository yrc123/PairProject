<template>
    <div>
        <div>
            <el-row>
            <el-col :span="2" class="grid-content bg-purple-dark"><div><img alt="PaperRetriveal logo" src="../assets/PaperRetriveal-mini.png" class="logo" ></div></el-col>
            <el-col :span="14" class="grid-content bg-purple"><div><SearchView style="left:0px" /></div></el-col>
            <el-col :span="0" class="grid-content bg-purple"><div></div></el-col>
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

    </div>
</template>

<script>
import SearchView from '@/components/SearchView.vue'
export default {
    components:{
        SearchView,
    },
    setup() {
        
    },
}
</script>
<style scoped>
.logo {
        width:90px;
        height:50px;
        margin:0px;
}
</style>