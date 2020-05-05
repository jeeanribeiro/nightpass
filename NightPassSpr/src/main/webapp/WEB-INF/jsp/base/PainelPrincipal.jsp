<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<tags:template 
title="NightPass - Principal"
cssProprio="/resources/css/PainelPrincipal.css"
jsProprio="/resources/js/PainelPrincipal.js">
    
        <div class="baseprincipal">

            <div class="corpobase">

				<%--INÍCIO DOS BLOCOS DE ESTABELECIMENTOS --%>
			
			    <c:set var="seqEst" value="${1}"/>
			
				<c:forEach items="${estabelecimentos}" var="e" >
				
			       <c:if test="${e.getGaleriaEst().size() >= 3}">	
							
					        <div class="containerEstabelecimento">
			
			                    <div class="basecomponentes">
			                    
			                    <%-- CARREGA AS FOTOS DE FACHADA E LOGOTIPO DO ESTABELECIMENTO --%>
			                    
			                     <c:set var="seqfoto" value="1"/>
			                     
			                     <c:forEach items="${e.getGaleriaEst()}" var="g" end="4">
			                     
			                     <c:set var="endfotoatual" value="resources/imgs/EstabelecimentoSemFoto.jpg"/>
			                     
										<div class="logobase">
											<div class="logofundo">
												
												<c:if test="${g.gae_tga_codigo.tgacodigo == 3}">
													<c:set var="endfotoatual" value="${g.gae_EndServidor}"/>
												</c:if>
												
												<img class="fotologo" src="${endfotoatual}">
												
											</div>
										</div>
			
										<div class="foto${seqfoto}">
											
											<c:if test="${g.gae_tga_codigo.tgacodigo == 1
															&& not empty g.gae_EndServidor}">
											
												<c:set var="endfotoatual" value="${g.gae_EndServidor}"/>
											
											</c:if>
											
											<c:if test="${seqfoto <=3 && seqfoto != 1}">
											<img id="${seqEst}_foto${seqfoto}" class="fmtfotosecundaria"
													src="${endfotoatual}">
											<c:set var="seqfoto" value="${seqfoto + 1}"/>
											</c:if>
											
											<c:if test="${seqfoto == 1}">
											<img id="${seqEst}_foto${seqfoto}" class="fmtfotoprincipal"
													src="${endfotoatual}">
											<c:set var="seqfoto" value="${seqfoto + 1}"/>
											</c:if>
											
											
											
										</div>
			
									<c:set var="endfotoatual" value="resources/imgs/EstabelecimentoSemFoto.jpg"/>
			
			                    </c:forEach>
			
									<div class="descricao">
			
										<div class="caixadescricao">
										
			                                <div class="alinhardiv">
			                                    <span class="fontenomeEst"> ${e.PSJ_CODIGO.psjNome} </span>
			                                </div>
										
											<div class="textodescricao">${e.estDescricao}</div>
			
									<div class="btnentrar">
										<c:url value="/agenda/${e.estcodigo}" var="agenda" />
										<form:form action="${agenda}" method="get">
											<input type="submit" value="ENTRE">
										</form:form>
										
									</div>
			
			
										</div>
									</div>
			
								</div>
			
			                </div>
			                
			            <c:set var="seqEst" value="${seqEst + 1}"/>
			            
			       </c:if>
			
				</c:forEach>

            </div>

            <div class="mnlateral">

                <div class="btnlateral">
                    TIPO
                </div>

                <div class="btnlateral">
                    MUSICAS
                </div>

                <div class="btnlateral">
                    PÚBLICO
                </div>

            </div>

            <div class="mntopo">
            
                <div class="establishment-title">
                    NigthPass
                </div>

                <div class="dropdown">
                    <div class="dropbtn">
                        Olá ${usuarioLog.nome}
                    </div>

                    <div class="dropdown-content">

					<c:url value="/cadastrousuario/dadosConta" var="conta" />
					<form:form action="${conta}" method="get">
					<input type="submit" value="Sua conta">
					</form:form>

					<c:url value="/buscarTodasPJGestor" var="action" />
					<form:form action="${action }" method="get">
					<input type="submit" value="Acesso gestor">
					</form:form>

					<input type="button" onclick="window.location.href='/NightPassSpr/signout'" value="Sair">

                </div>

            </div>




        </div>

		</div>

</tags:template>
