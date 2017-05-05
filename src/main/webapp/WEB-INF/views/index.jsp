<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/WEB-INF/views/common/head.jsp" %>

</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="common/header.jsp" %>
    <%@include file="common/menu.jsp" %>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                主面板
                <small>显示系统信息</small>
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">

            <div class="row">
                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box  bg-yellow">
                        <div class="inner">
                            <h3>0.00</h3>
                            <p>今日收款</p>
                        </div>
                        <div class="icon">
                            <i class="fa fa-jpy"></i>
                        </div>
                        <a href="#" class="small-box-footer">详细信息 <i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div><!-- ./col -->

                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-aqua">
                        <div class="inner">
                            <h3>0</h3>
                            <p>今日订单数</p>
                        </div>
                        <div class="icon">
                            <i class="fa fa-cart-plus"></i>
                        </div>
                        <a href="#" class="small-box-footer">详细信息 <i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div><!-- ./col -->

                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box  bg-red">
                        <div class="inner">
                            <h3>0.00</h3>
                            <p>累计收款</p>
                        </div>
                        <div class="icon">
                            <i class="fa  fa-btc"></i>
                        </div>
                        <a href="#" class="small-box-footer">详细信息 <i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div><!-- ./col -->

                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-green">
                        <div class="inner">
                            <h3>0</h3>
                            <p>累计订单数</p>
                        </div>
                        <div class="icon">
                            <i class="fa fa-car"></i>
                        </div>
                        <a href="#" class="small-box-footer">详细信息 <i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div><!-- ./col -->
                <!-- fix for small devices only -->
                <div class="clearfix visible-sm-block"></div>
            </div><!-- /.row -->

            <div class="row">
                <div class="col-md-12">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">最近十二个月的收益趋势图(金额（单位:万元）/月)</h3>
                            <div class="box-tools pull-right">
                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                            </div>
                        </div>
                        <div class="box-body">
                            <div class="chart">
                                <canvas id="lineChart" style="height:400px"></canvas>
                            </div>
                        </div><!-- /.box-body -->
                    </div><!-- /.box -->
                </div>
            </div>

        </section><!-- /.content -->
    </div><!-- /.content-wrapper -->


    <%@include file="common/footer.jsp" %>
    <div class="control-sidebar-bg"></div>
</div>

</body>
</html>

