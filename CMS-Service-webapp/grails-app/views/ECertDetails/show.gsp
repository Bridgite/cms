

<!doctype html>
<html>
    <head>
        <meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'ECertDetails.label', default: 'ECertDetails')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    
  
    </head>
    <body> 
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">e-Certificate details </h1> 
                <g:link class="list" action="index"><input type="button" value="e-Certificates listing" class="btn btn-success" /></g:link>

                <br> <br> 
            </div>   <div class="col-lg-12">
                <div class="panel panel-default">

                    <div class="panel-heading">
                        Certificate No: [<i> <g:fieldValue bean="${ECertDetailsInstance}" field="certNo"/> </i>]  details
                    </div>
                    <br>  
                    <g:if test="${flash.message}">
                        <div class="message" role="status">${flash.message}</div>
                    </g:if>
                   <div class="inlinetab">
                    <ol class="property-list eCertDetails">

                        <g:if test="${ECertDetailsInstance?.certFile}">
                            <div class="form-group">
                                <span  class="property-label"><g:message code="ECertDetails.certFile.label" default="File name" /> : </span>

                                <span  class="property-value"><g:fieldValue bean="${ECertDetailsInstance}" field="certFile"/></span>
                            </div>
                        </g:if>
                        <div class="form-group">
                            <g:if test="${ECertDetailsInstance?.certNo}">
                                <span  class="property-label"><g:message code="ECertDetails.certNo.label" default="Certificate No" /> : </span>

                                <span  class="property-value"><g:fieldValue bean="${ECertDetailsInstance}" field="certNo"/> </span>

                            </g:if>
                        </div>
                        <div class="form-group">
                            <g:if test="${ECertDetailsInstance?.certStatus}">
                                <span  class="property-label"><g:message code="ECertDetails.certStatus.label" default="Certificate status" />: </span>

                                <span  class="property-value"><g:fieldValue bean="${ECertDetailsInstance}" field="certStatus"/> </span>

                            </g:if>
                        </div>
                        <div class="form-group">
                            <g:if test="${ECertDetailsInstance?.statusDate}">
                                <span  class="property-label"><g:message code="ECertDetails.statusDate.label" default="Status date" />: </span>

                                <span  class="property-value"><g:formatDate date="${ECertDetailsInstance?.statusDate}" /> </span>

                            </g:if>
                        </div>
                        <div class="form-group">
                            <g:if test="${ECertDetailsInstance?.destinationCountry}">
                                <span  class="property-label"><g:message code="ECertDetails.destinationCountry.label" default="Destination country" />: </span>

                                <span  class="property-value"><g:fieldValue bean="${ECertDetailsInstance}" field="destinationCountry"/> </span>

                            </g:if>
                        </div>
                        <div class="form-group">
                            <g:if test="${ECertDetailsInstance?.dateOfIssue}">
                                <span  class="property-label"><g:message code="ECertDetails.dateOfIssue.label" default="Date of issue" /> : </span>

                                <span  class="property-value"><g:formatDate date="${ECertDetailsInstance?.dateOfIssue}" /> </span>

                            </g:if>
                        </div>
                        <div class="form-group">
                            <g:if test="${ECertDetailsInstance?.certType}">
                                <span  class="property-label"><g:message code="ECertDetails.certType.label" default="Certificate type" /> : </span>

                                <span  class="property-value"><g:fieldValue bean="${ECertDetailsInstance}" field="certType"/> </span>

                            </g:if>
                        </div><div class="form-group">
                            <g:if test="${ECertDetailsInstance?.ECertStatusHistories}">
                                <span  class="property-label"><g:message code="ECertDetails.ECertStatusHistories.label" default="Status log" /> : </span>

                                <g:each in="${ECertDetailsInstance.ECertStatusHistories}" var="E">
                                    <span  class="property-value"><g:link controller="ECertStatusHistory" action="show" id="${E.id}">${E.certStatus.encodeAsHTML()}</g:link> </span>
                                </g:each>

                            </g:if>
                        </div><div class="form-group">
                            <g:if test="${ECertDetailsInstance?.issuer}">
                                <span  class="property-label"><g:message code="ECertDetails.issuer.label" default="Issuer" /> </span>

                                <span  class="property-value"><g:fieldValue bean="${ECertDetailsInstance}" field="issuer"/> </span>

                            </g:if>
                        </div>
 <div class="form-group">
                            <g:if test="${ECertDetailsInstance?.placeOfIssue}">
                                <span  class="property-label"><g:message code="ECertDetails.placeOfIssue.label" default="Place Of Issue" /> </span>

                                <span  class="property-value"><g:fieldValue bean="${ECertDetailsInstance}" field="placeOfIssue"/> </span>

                            </g:if></div>
<div class="form-group">
                            <g:if test="${ECertDetailsInstance?.pdfCertFilePath}">
                                <span  class="property-label"><g:message code="ECertDetails.pdfCertFilePath.label" default="PDF certificate" /> : </span>

                                <span  class="property-value"><a href="${fieldValue(bean: ECertDetailsInstance, field: "pdfCertFilePath")}" target="blank"><g:fieldValue bean="${ECertDetailsInstance}" field="pdfCertFilePath"/> </a> </span>

                            </g:if>
                        </div>
                           
                      <div class="form-group">
                            <g:if test="${ECertDetailsInstance?.xmlCertFilePath}">
                                <span  class="property-label"><g:message code="ECertDetails.xmlCertFilePath.label" default="XML certificate " /> : </span>

    
                                <span  class="property-value"><g:link controller="ECertDetails" action="downloadXmlFileCert" id="${ECertDetailsInstance.id}"><g:fieldValue bean="${ECertDetailsInstance}" field="xmlCertFilePath"/> </g:link> </span>

                            </g:if>
                        </div>
  <div class="form-group">
                            <g:if test="${ECertDetailsInstance?.signedXmlCertFilePath}">
                                <span  class="property-label"> <g:message code="ECertDetails.signedXmlCertFilePath.label" default="Signed XML certificate" /> : </span>

                                <span  class="property-value"><g:link controller="ECertDetails" action="downloadSignedXmlFileCert" id="${ECertDetailsInstance.id}"><g:fieldValue bean="${ECertDetailsInstance}" field="signedXmlCertFilePath"/> </g:link> </span>

                            </g:if>
                        </div>
                    </ol>
                        <dl id="demo" class="smart-tabs">
<dt>
<a href="#">PDF File</a></dt>
    <dd>
 
   <div id="pdfRenderer" style="width:330px;height:500px;">
   <object  src="${fieldValue(bean: ECertDetailsInstance, field: "pdfCertFilePath")}" width="330px" height="500px">
    <embed  src="${fieldValue(bean: ECertDetailsInstance, field: "pdfCertFilePath")}" width="330px" height="500px">
    </embed>
</object></div></dd>
 
    <dt><a href="#">XML File</a></dt>
    <dd style="width:330px;height:500px;">
          
         <pre class="xmldiv">
<xmp>
        <g:include  action="viewXmlFileCert"  id="${ECertDetailsInstance.id}" />
  </xmp>
    </dd>
<!--
    <dt><a href="#">Signed XML File</a></dt>
    <dd>   <iframe width="300" height="350" style="width:300px;height:350px;" id="iframe3" src=""></iframe>
    </dd>

</dl> -->
</div>
                    <g:form>
<fieldset class="buttons"><p align="justify"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <g:hiddenField name="id" value="${ECertDetailsInstance?.id}" />
                        <input type="button" value="Accept pdf" onclick="goBack()" class="btn btn-success">
                        <input type="button" value="Accept xml" onclick="goBack()" class="btn btn-success">
                        
                         <input type="button" value="Acknowledge" onclick="goBack()" class="btn btn-success">
                            
                            <input type="button" value="Back" onclick="goBack()" class="btn btn-success">
                         </p></fieldset>
                    </g:form>

                </div>
            </div>
            </div>
    </body>
</html>
