
                
                        <h3 class="page-header"><br>CMS Dashboard</h3>
              
                <!-- /.row -->
<sec:ifAnyGranted roles="ROLE_WEB_USER">  
                <div class="row">
                    
                <div class="col-lg-12"> 
                </div>
                <!-- /.col-lg-12 --> 
                   </div>
               <!-- /.row -->
                <div class="row">
                    <div class="col-lg-8">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class="fa fa-bar-chart-o fa-fw"></i> e-Phyto Transaction volumes
                                <div class="pull-right">
                                    <div class="btn-group">
                                        <!-- <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
                                            Actions
                                            <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu pull-right" role="menu">
                                            <li><a href="#">Action</a>
                                            </li>
                                            <li><a href="#">Another action</a>
                                            </li>
                                            <li><a href="#">Something else here</a>
                                            </li>
                                            <li class="divider"></li>
                                            <li><a href="#">Separated link</a>
                                            </li>
                                        </ul>-->
                                    </div>
                                </div>
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body">
                                <div id="morris-area-chart"></div>
                            </div>
                            <!-- /.panel-body -->
                        </div>

                    </div>
                    <!-- /.col-lg-8 -->
                    <div class="col-lg-4">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <i class="fa fa-bell fa-fw"></i> E Certificates and Profile details Panel
                            </div>
                            <!-- /.panel-heading -->
                            <div class="panel-body"> 
                                <!-- /.list-group -->
                                  <div >
                          <g:link controller="ECertDetails" action="index"> <div class="panel panel-primary">
                            <div class="panel-heading">
                             
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-files-o  fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        
                                        <div class="huge">
                                            ${ECertDetails.countBydestinationCountryLike("${User.findById((sec.loggedInUserInfo(field:'id'))).countrycode}")}</div>
                                        <div>e-Phyto Certificates. </div>
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
                    
                                  <div><g:link controller="User" action="show" id="${(sec.loggedInUserInfo(field:'id'))}">
                        <div class="panel panel-yellow">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-user fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge"> Id ${(sec.loggedInUserInfo(field:'id'))}</div>
                                        <div>View my profile details</div>
                                    </div>
                                </div>
                            </div>
                            <g:link controller="User" action="edit" id="${(sec.loggedInUserInfo(field:'id'))}">
                                <div class="panel-footer">
                                    <span class="pull-left">Edit my profile details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </g:link>
                        </div></g:link>
                    </div>
                                 </div>
                            <!-- /.panel-body -->
                        </div>

                        <!-- /.panel .chat-panel -->
                    </div>
                    <!-- /.col-lg-4 -->
                </div>
                             
                 
                
                </sec:ifAnyGranted>
                <sec:ifAnyGranted roles="ROLE_SUPER_ADMIN_USER">  
                <div class="row">
                    
                <div class="col-lg-12">
                    <h4 class="page-header">E Certificates</h4>
                </div>
                <!-- /.col-lg-12 -->
          
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
            
          
                </div>
                
                </sec:ifAnyGranted>
                <sec:ifAnyGranted roles="ROLE_SUPER_ADMIN_USER">
                                <div class="row">
                                      <div class="col-lg-12">
                    <h4 class="page-header active">Translation tables</h4>
                </div>
                    <div class="col-lg-3 col-md-6"><g:link controller="TrnsltCommodityClassCode" action="index">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-table fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${TrnsltCommodityClassCode.count()}</div>
                                        <div>Commodity Class </div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left"> Translations table</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div></g:link>
                    </div>
                    <div class="col-lg-3 col-md-6"><g:link controller="TrnsltEpptBotanicalName" action="index">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-table fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                         <g:set var="EpptBotanicalNamecount" value="${TrnsltEpptBotanicalName.count()}" />
                                        <div class="huge">${EpptBotanicalNamecount}</div>
                                        <div>Eppt Botanical Name</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left"> Translation table</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div></g:link>
                    </div>
                    <div class="col-lg-3 col-md-6"><g:link controller="TrnsltRecipientSpsParty" action="index">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-table fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${TrnsltRecipientSpsParty.count()}</div>
                                        <div>SPS Party </div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left"> Translation table</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div></g:link>
                    </div>
                <div class="col-lg-3 col-md-6"><g:link controller="TrnsltPackageTypeCode" action="index">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-table fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${TrnsltPackageTypeCode.count()}</div>
                                        <div>Package types</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left"> Translation table</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div></g:link>
                    </div>
                </div>
                                <div class="row">
                <div class="col-lg-3 col-md-6"><g:link controller="TrnsltTransportmodeCode" action="index">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-table fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${TrnsltTransportmodeCode.count()}</div>
                                        <div>Transport mode</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left"> Translation tables</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div></g:link>
                    </div>
                    <div class="col-lg-3 col-md-6"><g:link controller="TrnsltUnLocode" action="index">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-table fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${TrnsltUnLocode.count()}</div>
                                        <div>Un Location </div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left"> Translation table</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div></g:link>
                    </div>
                   <div class="col-lg-3 col-md-6"><g:link controller="TrnsltMeasurementCommonCode" action="index">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-table fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${TrnsltMeasurementCommonCode.count()}</div>
                                        <div>Measurements  </div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left"> Translation table</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div></g:link>
                    </div>
                 <div class="col-lg-3 col-md-6"><g:link controller="TrnsltDocumentType" action="index">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-table fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${TrnsltDocumentType.count()}</div>
                                        <div> Document Types </div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left"> Translation table</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div></g:link>
                    </div>
                                     <div class="col-lg-3 col-md-6"><g:link controller="TrnsltCountryIsoCode" action="index">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-table fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${TrnsltCountryIsoCode.count()}</div>
                                        <div>  Country ISO code </div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left"> Translation table</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div></g:link>
                    </div>
                </div>
                 <sec:ifAnyGranted roles="ROLE_SUPER_ADMIN_USER">  
                 <div class="col-lg-12">
                    <h4 class="page-header">User Details & Configuration </h4>
                </div>
                                <div class="row">
           <div class="col-lg-3 col-md-6"><g:link controller="User" action="index">
                        <div class="panel panel-yellow">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-user fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${User.count()}</div>
                                        <div>User details</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">View User details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div></g:link>
                    </div>
                    </sec:ifAnyGranted>
                   <div class="col-lg-3 col-md-6"><g:link controller="UserRole" action="index">
                        <div class="panel panel-yellow">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-user fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${UserRole.count()}</div>
                                        <div>User roles</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">View User roles</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div></g:link>
                    </div>
                    <div class="col-lg-3 col-md-6"><g:link controller="Role" action="index">
                        <div class="panel panel-yellow">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-user fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${Role.count()}</div>
                                        <div>Role authorisation</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">View User role authorisation</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div></g:link>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-red">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-wrench fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">13</div>
                                        <div> Configuration</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left">View Configuration</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
                 
 </sec:ifAnyGranted>  
    
        <script src="${request.contextPath}/cms_ui_theme/js/plugins/morris/raphael.min.js"></script>
 <script src="${request.contextPath}/cms_ui_theme/js/plugins/morris/morris.min.js"></script>
        

        <g:javascript>
  

$(document).ready(function(){

    $.ajax({
        url: '${g.createLink(controller:'ECertDetails',action:'returnReportsData')}',
         dataType: "json", 
        data: {get_values: true},
        success: function(response) { 
        Morris.Area({
                element: 'morris-area-chart',
               data:response,
                lineColors: ['#f0ad4e', '#F79263', '#1AB244'],
               // barColors: ["#f0ad4e", "#1531B2", "#1AB244", "#B29215"],
                xkey: 'dateOfIssue',
                ykeys: ['total_certificates','acknowledged_status_count','approved_status_count'],
                labels: ['total certificates','acknowledged certificates','approved certificates']
            });
          
        }
    });

});
        
        </g:javascript>