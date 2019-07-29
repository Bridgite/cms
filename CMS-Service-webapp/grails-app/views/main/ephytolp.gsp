
                
                <!-- /.row -->
                <div class="row">
                      
                <div class="col-lg-12">
                    <h4 class="page-header">E Certificates</h4>
                </div>
                <div class="col-lg-3 col-md-6">
                          <g:link controller="ECertDetails" action="index"> <div class="panel panel-primary">
                            <div class="panel-heading">
                             
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-files-o  fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${ECertDetails.count()}</div>
                                        <div>e-Phyto Certificates</div>
                                    </div>
                                </div>
                            </div>
                            <a href="main/ephytolp">
                                <div class="panel-footer">
                                    <span class="pull-left">view e-Phyto Certificates</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                        </g:link>
                    </div>
                    
  <sec:ifAnyGranted roles="ROLE_ADMIN_WEB_USER,ROLE_SUPER_ADMIN_USER">
                    <div class="col-lg-3 col-md-6">
                          <g:link controller="ECertStatusHistory" action="index"> <div class="panel panel-primary">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-files-o fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <g:set var="ephytoshistorycount" value="${ ECertStatusHistory.count()}" />
                                        <div class="huge">${ephytoshistorycount}</div>
                                        <div>e-Phyto History</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">View e-Phyto History</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                        </g:link>
                    </div>
            
                    </sec:ifAnyGranted>
            
          
                </div> 
                
                 
