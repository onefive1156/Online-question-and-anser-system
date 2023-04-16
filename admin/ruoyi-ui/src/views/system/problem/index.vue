<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="作者id
" prop="authorId">
        <el-input
          v-model="queryParams.authorId"
          placeholder="请输入作者id
"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="" prop="createTime">
        <el-date-picker clearable
          v-model="queryParams.createTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:problem:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:problem:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:problem:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:problem:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="problemList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="问题id" align="center" prop="id" />
      <el-table-column label="问题名称" align="center" prop="name" />
      <el-table-column label="作者id
" align="center" prop="authorId" />
      <el-table-column label="问题描述
" align="center" prop="details" />
      <el-table-column label="问题图片路径" align="center" prop="imgUrl" />
      <el-table-column label="" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:problem:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:problem:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改问题管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="问题名称" prop="name">
          <el-input v-model="form.name" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="作者id
" prop="authorId">
          <el-input v-model="form.authorId" placeholder="请输入作者id
" />
        </el-form-item>
        <el-form-item label="问题描述
" prop="details">
          <el-input v-model="form.details" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="问题图片路径" prop="imgUrl">
          <el-input v-model="form.imgUrl" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="" prop="delFlag">
          <el-input v-model="form.delFlag" placeholder="请输入" />
        </el-form-item>
        <el-divider content-position="center">回答管理信息</el-divider>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAddAnswer">添加</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" icon="el-icon-delete" size="mini" @click="handleDeleteAnswer">删除</el-button>
          </el-col>
        </el-row>
        <el-table :data="answerList" :row-class-name="rowAnswerIndex" @selection-change="handleAnswerSelectionChange" ref="answer">
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column label="序号" align="center" prop="index" width="50"/>
          <el-table-column label="" prop="name" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.name" placeholder="请输入" />
            </template>
          </el-table-column>
          <el-table-column label="" prop="authorId" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.authorId" placeholder="请输入" />
            </template>
          </el-table-column>
          <el-table-column label="" prop="likes" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.likes" placeholder="请输入" />
            </template>
          </el-table-column>
          <el-table-column label="" prop="createTime" width="240">
            <template slot-scope="scope">
              <el-date-picker clearable v-model="scope.row.createTime" type="date" value-format="yyyy-MM-dd" placeholder="请选择" />
            </template>
          </el-table-column>
          <el-table-column label="" prop="editeTime" width="240">
            <template slot-scope="scope">
              <el-date-picker clearable v-model="scope.row.editeTime" type="date" value-format="yyyy-MM-dd" placeholder="请选择" />
            </template>
          </el-table-column>
        </el-table>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listProblem, getProblem, delProblem, addProblem, updateProblem } from "@/api/system/problem";

export default {
  name: "Problem",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 子表选中数据
      checkedAnswer: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 问题管理表格数据
      problemList: [],
      // 回答管理表格数据
      answerList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        authorId: null,
        details: null,
        imgUrl: null,
        createTime: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询问题管理列表 */
    getList() {
      this.loading = true;
      listProblem(this.queryParams).then(response => {
        this.problemList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        name: null,
        authorId: null,
        details: null,
        imgUrl: null,
        createTime: null,
        delFlag: null
      };
      this.answerList = [];
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加问题管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getProblem(id).then(response => {
        this.form = response.data;
        this.answerList = response.data.answerList;
        this.open = true;
        this.title = "修改问题管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.answerList = this.answerList;
          if (this.form.id != null) {
            updateProblem(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addProblem(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除问题管理编号为"' + ids + '"的数据项？').then(function() {
        return delProblem(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
	/** 回答管理序号 */
    rowAnswerIndex({ row, rowIndex }) {
      row.index = rowIndex + 1;
    },
    /** 回答管理添加按钮操作 */
    handleAddAnswer() {
      let obj = {};
      obj.name = "";
      obj.authorId = "";
      obj.details = "";
      obj.imgUrl = "";
      obj.likes = "";
      obj.createTime = "";
      obj.editeTime = "";
      this.answerList.push(obj);
    },
    /** 回答管理删除按钮操作 */
    handleDeleteAnswer() {
      if (this.checkedAnswer.length == 0) {
        this.$modal.msgError("请先选择要删除的回答管理数据");
      } else {
        const answerList = this.answerList;
        const checkedAnswer = this.checkedAnswer;
        this.answerList = answerList.filter(function(item) {
          return checkedAnswer.indexOf(item.index) == -1
        });
      }
    },
    /** 复选框选中数据 */
    handleAnswerSelectionChange(selection) {
      this.checkedAnswer = selection.map(item => item.index)
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/problem/export', {
        ...this.queryParams
      }, `problem_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
