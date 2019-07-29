<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>CMS System</title>

    <!-- Bootstrap Core CSS -->
        <link href="${request.contextPath}/cms_ui_theme/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
        <link href="${request.contextPath}/cms_ui_theme/css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
        <link href="${request.contextPath}/cms_ui_theme/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
        <link href="${request.contextPath}/cms_ui_theme/font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <script src="${request.contextPath}/cms_ui_theme/js/jquery-1.11.0.js"></script>
           <!-- DataTables JavaScript -->
        <script src="${request.contextPath}/cms_ui_theme/js/plugins/dataTables/jquery.dataTables.js"></script>
        <script src="${request.contextPath}/cms_ui_theme/js/plugins/dataTables/dataTables.bootstrap.js"></script>
        <script src="${request.contextPath}/cms_ui_theme/js/bootstrap.min.js"></script>
<script src="${request.contextPath}/cms_ui_theme/js/smartTabs.js"></script>


        <!-- Metis Menu Plugin JavaScript -->
        <script src="${request.contextPath}/cms_ui_theme/js/plugins/metisMenu/metisMenu.min.js"></script>

        <!-- Custom Theme JavaScript -->
        <script src="${request.contextPath}/cms_ui_theme/js/sb-admin-2.js"></script>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
   <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
   <!--[if lt IE 9]>
       <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
       <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
   <![endif]-->

        <g:javascript>

            $(document).ready(function(){
            $('#dataTable-country').DataTable();
            });</g:javascript>

        <g:javascript>
            $(document).ready(function(){
            $('#dataTables-example').DataTable();
            $('#demo').smartTabs();

            });
 
        </g:javascript>
  <g:javascript>
     var iframe = $('#iframe1')
     var url = iframe.attr('src')
      var urlChunks = window.location.href.split('/');
      var id='/'+(urlChunks[urlChunks.length - 1]);
     // $.post('${createLink(controller: 'ECertDetails', action: 'downloadPdfFileCert')}'+id, {ur: url})
console.log('${createLink(controller: 'ECertDetails', action: 'downloadPdfFileCert')}'+id);
  </g:javascript>
          <g:javascript>
    function goBack() {
        window.history.back()
    }
</g:javascript>
        <g:javascript>
            //
            // Pipelining function for DataTables. To be used to the `ajax` option of DataTables
            //
            $.fn.dataTable.pipeline = function ( opts ) {
            // Configuration options
            var conf = $.extend( {
            pages: 5,     // number of pages to cache
            url: '',      // script url
            data: null,   // function or object with parameters to send to the server
            // matching how `ajax.data` works in DataTables
            method: 'GET' // Ajax HTTP method
            }, opts );

            // Private variables for storing the cache
            var cacheLower = -1;
            var cacheUpper = null;
            var cacheLastRequest = null;
            var cacheLastJson = null;

            return function ( request, drawCallback, settings ) {
            var ajax          = false;
            var requestStart  = request.start;
            var drawStart     = request.start;
            var requestLength = request.length;
            var requestEnd    = requestStart + requestLength;

            if ( settings.clearCache ) {
            // API requested that the cache be cleared
            ajax = true;
            settings.clearCache = false;
            }
            else if ( cacheLower < 0 || requestStart < cacheLower || requestEnd > cacheUpper ) {
            // outside cached data - need to make a request
            ajax = true;
            }
            else if ( JSON.stringify( request.order )   !== JSON.stringify( cacheLastRequest.order ) ||
            JSON.stringify( request.columns ) !== JSON.stringify( cacheLastRequest.columns ) ||
            JSON.stringify( request.search )  !== JSON.stringify( cacheLastRequest.search )
            ) {
            // properties changed (ordering, columns, searching)
            ajax = true;
            }

            // Store the request for checking next time around
            cacheLastRequest = $.extend( true, {}, request );

            if ( ajax ) {
            // Need data from the server
            if ( requestStart < cacheLower ) {
            requestStart = requestStart - (requestLength*(conf.pages-1));

            if ( requestStart < 0 ) {
            requestStart = 0;
            }
            }

            cacheLower = requestStart;
            cacheUpper = requestStart + (requestLength * conf.pages);

            request.start = requestStart;
            request.length = requestLength*conf.pages;

            // Provide the same `data` options as DataTables.
            if ( $.isFunction ( conf.data ) ) {
            // As a function it is executed with the data object as an arg
            // for manipulation. If an object is returned, it is used as the
            // data object to submit
            var d = conf.data( request );
            if ( d ) {
            $.extend( request, d );
            }
            }
            else if ( $.isPlainObject( conf.data ) ) {
            // As an object, the data given extends the default
            $.extend( request, conf.data );
            }

            settings.jqXHR = $.ajax( {
            "type":     conf.method,
            "url":      conf.url,
            "data":     request,
            "dataType": "json",
            "cache":    false,
            "success":  function ( json ) {
            cacheLastJson = $.extend(true, {}, json);

            if ( cacheLower != drawStart ) {
            json.data.splice( 0, drawStart-cacheLower );
            }
            json.data.splice( requestLength, json.data.length );

            drawCallback( json );
            }
            } );
            }
            else {
            json = $.extend( true, {}, cacheLastJson );
            json.draw = request.draw; // Update the echo for each response
            json.data.splice( 0, requestStart-cacheLower );
            json.data.splice( requestLength, json.data.length );

            drawCallback(json);
            }
            }
            };
            $(document).ready(function(){
            $('#dataTables-eppt').dataTable({
            "bProcessing": true, 
            "bDeferRender": true,
            "sAjaxSource":'${createLink (action:'returnJSON')}'
            });
            });
          
            $(document).ready(function() {
            $('#dataTables-ecert').dataTable( {
            "bProcessing": true, 
            "bDeferRender": true,
            "deferRender": true, 
            //   "bSortClasses": false,
            // "processing": true,
            // "serverSide": true,  
            //"iDisplayStart":0,
            //"iDisplayLength":10,
            // "scrollY": "400px",
            //  "dom": "frtiS",
            //  "deferRender": true,
             "aoColumnDefs": [ 
             { "bVisible": false, "aTargets": [ 0 ] },
             { "bVisible": true, "aTargets": [ 1,2,3,4 ] },

     {
       "aTargets": [4], // Column to target
       "mRender": function ( data, type, full ) {
         // 'full' is the row's data object, and 'data' is this column's data
         // e.g. 'full[0]' is the comic id, and 'data' is the comic title
         return '<a href="/CMS-Service-webapp/ECertDetails/show/' + full[0] + '">' + "Show details" + '</a>';
       }
     }
   ] ,
            "ajax": ( {
        url: '${g.createLink(controller:'ECertDetails',action:'returnJSON')}',
        pages:5 // number of pages to cache
        } )
        } );
        } ); 
            $(document).ready(function() {
            $('#dataTablesunlocode').dataTable( {
            "bProcessing": true, 
            "bDeferRender": true,
            "deferRender": true, 
            //   "bSortClasses": false,
            // "processing": true,
            // "serverSide": true,  
            //"iDisplayStart":0,
            //"iDisplayLength":10,
            // "scrollY": "400px",
            //  "dom": "frtiS",
            //  "deferRender": true,
            "aoColumnDefs": [            
            {
            "aTargets": [0], // Column to target
            "mRender": function ( data, type, full ) {
            // 'full' is the row's data object, and 'data' is this column's data
            // e.g. 'full[0]' is the comic id, and 'data' is the comic title
            return '<a href="/CMS-Service-webapp/trnsltUnLocode/show/+full[0]+">' + data + '</a>';
            }
            }
            ],
            "ajax": ( {
        url: '${g.createLink(controller:'trnsltUnLocode',action:'returnJSON')}',
        pages:5 // number of pages to cache
        } )
        } );
        } ); 


<!-- </g:javascript>
<!-- <script src="${request.contextPath}/cms_ui_theme/js/plugins/metisMenu/metisMenu.min.js"></script>
  <g:javascript>
         $(function () {
        $("#sidemenu").metisMenu({
    toggle: false
  });
});
</g:javascript > -->
    </head>
    <body>
        <div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
                <img src="${resource(dir:'images',file:'header.jpg')}" alt="" title="Kenya Plant Health Inspectorate Service- Electronic Certification System" height="107" width="1300">

                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>

                </div>
                <!-- /.navbar-header -->

                <ul class="nav navbar-top-links navbar-right">

                    <li> 
                        <div id="loginHeader">
                            <g:loginControl />
                        </div>
                    </li>
                              <!-- /.dropdown -->
                    <li class="dropdown">
                         
                        <ul class="dropdown-menu dropdown-alerts">
                            <li>
                                <a href="#">
                                    <div>
                                        <i class="fa fa-comment fa-fw"></i> New Comment
                                        <span class="pull-right text-muted small">4 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <div>
                                        <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                        <span class="pull-right text-muted small">12 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <div>
                                        <i class="fa fa-envelope fa-fw"></i> Message Sent
                                        <span class="pull-right text-muted small">4 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <div>
                                        <i class="fa fa-tasks fa-fw"></i> New Task
                                        <span class="pull-right text-muted small">4 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="#">
                                    <div>
                                        <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                        <span class="pull-right text-muted small">4 minutes ago</span>
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a class="text-center" href="#">
                                    <strong>See All Alerts</strong>
                                    <i class="fa fa-angle-right"></i>
                                </a>
                            </li>
                        </ul>
                        <!-- /.dropdown-alerts -->
                    </li>
                    <!-- /.dropdown -->
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li>
                                 <g:link controller="User" action="show" id="${(sec.loggedInUserInfo(field:'id'))}">
                                     <i class="fa fa-user fa-fw"></i> User Profile</g:link>
                            </li>
                             
                            <li class="divider"></li>
                            <li>
<g:remoteLink class="logout" controller="logout" method="post" asynchronous="false" onSuccess="location.reload()">Logout<i class="fa fa-sign-out fa-fw"></i> Logout</g:remoteLink>
 
                                </li>
                            </ul>

<!-- /.dropdown-user -->
                    </li>
                    <!-- /.dropdown -->
                </ul>
                <!-- /.navbar-top-links -->

                <div class="navbar-default sidebar" role="navigation">
                    <div class="sidebar-nav navbar-collapse">
                        <ul id="side-menu"  class="nav" >

                            <li class="active">
                                <a href="${createLink(uri: '/main/home')}"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                            </li>



                            <li>
                                <a class="doubleTapToGo" href="${createLink(uri: '/main/ephytolp')}"> <i class="fa fa-edit fa-fw"></i>e-Phyto Certificates <span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level" id="menu2">
                                    <li>
                                        <a class="active" href="${createLink(uri: '/ECertDetails/index')}">e-Certificates</a>
                                    </li>
                                     <sec:ifAnyGranted roles="ROLE_ADMIN_WEB_USER,ROLE_SUPER_ADMIN_USER">
                                    <li>
                                        <a href="${createLink(uri: '/ecertificateHistory/index')}">e-Certificates History</a>
                                    </li>
                                     </sec:ifAnyGranted>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>
 <sec:ifAnyGranted roles="ROLE_SUPER_ADMIN_USER">
                            <li>
                                <a href="#"><i class="fa fa-table fa-fw"></i> Translation tables<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="${createLink(uri: '/trnsltCommodityClassCode/index')}">Commodity Class Code</a>
                                    </li>
                                    <li>
                                        <a href="${createLink(uri: '/trnsltEpptBotanicalName/index')}"> EPPT Botanical name</a>
                                    </li>      <li>
                                        <a href="${createLink(uri: '/trnsltRecipientSpsParty/index')}">Recipient Sps Party</a>
                                    </li>      <li>
                                        <a href="${createLink(uri: '/trnsltPackageTypeCode/index')}">Package Type Code</a>
                                    </li>      <li>
                                        <a href="${createLink(uri: '/trnsltTransportmodeCode/index')}">Transport mode Code</a>
                                    </li>      <li>
                                        <a href="${createLink(uri: '/trnsltUnLocode/index')}">UN Locode</a>
                                    </li>      <li>
                                        <a href="${createLink(uri: '/trnsltMeasurementCommonCode/index')}">Measurement Common Code</a>
                                    </li>      <li>
                                        <a href="${createLink(uri: '/trnsltDocumentType/index')}"> Document Type</a>
                                    </li>      <li>
                                        <a href="${createLink(uri: '/trnsltCountryIsoCode/index')}">Country ISO Code</a>
                                    </li>       

                                </ul>
                                <!-- /.nav-second-level -->
                            </li>

                    </sec:ifAnyGranted>
  <sec:ifAnyGranted roles="ROLE_ADMIN_WEB_USER,ROLE_SUPER_ADMIN_USER">
                            <li>
                                <a href="${createLink(uri: '/main/ephytolp')}"><i class="fa fa-edit fa-fw"></i>Users<span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a class="active" href="${createLink(uri: '/ecertUsers/index')}">User details</a>
                                    </li>
                                    <li>
                                        <a href="${createLink(uri: '/ecertRoles/index')}">User roles</a>
                                    </li>
                                    <li>
                                        <a href="${createLink(uri: '/ecertAuthorisation/index')}">Role Authorisation</a>
                                    </li>
                                </ul>
                                <!-- /.nav-second-level -->
                            </li>

                            <li>
                                <a href="#"><i class="fa fa-wrench fa-fw"></i> Configuration<span class="fa arrow"></span></a>
                             <!-- /.nav-second-level -->
                            </li>

                    </sec:ifAnyGranted>

                        </ul>
                    </div>
                    <!-- /.sidebar-collapse -->
                </div>
                <!-- /.navbar-static-side -->
            </nav>

            <!-- Page Content -->
            <div id="page-wrapper">
                <g:layoutBody></g:layoutBody>
                    <div class="footer" role="contentinfo"></div>
                    <div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"></g:message></div>

            </div>
                  <!-- /#page-wrapper -->

        </div>
        <!-- /#wrapper -->

        <!-- jQuery Version 1.11.0 -->


        <!-- Bootstrap Core JavaScript -->






    </body>

</html>