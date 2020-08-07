<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<tags:template
title="NightPass - Principal"
cssProprio="/resources/css/PainelPrincipal.css"
jsProprio="/resources/js/XPainelPrincipal.js">



<div class="baseprincipal">

            <div class="topo">

                <div class="LogoNPass">NigthPass</div>
                <div class="HeadMenuRight">login</div>

            </div>

            <div class="corpo">

				<c:forEach items="${estabelecimentos}" var="e" >


                <div class="boxEst">
                    
                    <div class="boxFormat">

                        <div class="boxFormat1">

                            <c:if test="${not empty e.getGaleriaEst().get(0).getGae_EndServidor()}">
                            <img class="formatImgEst" src="${e.getGaleriaEst().get(0).getGae_EndServidor()}">
                            </c:if>
                            
                            <c:if test="${empty e.getGaleriaEst().get(0).getGae_EndServidor()}">
                            <img class="formatImgEst" src="resources/imgs/EstabelecimentoSemFoto.jpg">
                            </c:if>
                            
                        
                        </div>

                        <div class="boxFormat2">

                            <img class="formatImgEstPeq1" src="resources/ImgBase/GIHviKUYRjMriNgglVvs_FotoCerveja.jpg"> 
                            <img class="formatImgEstPeq2" src="resources/ImgBase/QYnjVUxZmMvzycphrFuW_FotodoShow.jpg"> 

                            
                        </div>


                        <div class="boxFormat3">

                            <div class="fmtdivladoalado">
                            <img class="formatImgLogo" src="resources/ImgBase/BcuQGtFewuTdHYqypZRE_LogoBluePub.jpg"> 
                            <div class="Textosimples24 formatNomeEst">${e.getPSJ_CODIGO().getPsjNome()}</div>
                            </div>
                           
                            <div class="Textosimples18 formatEstInfo">
                                <span class= "Textosimplesneg18"> Músicas: </span> &nbsp Sertanejo Universitário, Pagode, Eletrônico<br>
                                <span class= "Textosimplesneg18">Distância:</span> &nbspa 3 km<br>
                                <span class= "Textosimplesneg18">Tipo:</span> &nbsp Bar<br>
                                <span class= "Textosimplesneg18"> Nota:</span> &nbsp 3,5<br><br>
                                <div class="tright">
                                A sacada de encontrar um ponto em comum para estrangeiros e brasileiros no mesmo lugar, foi o motivo pelo qual o The Blue Pub nasceu. Desde janeiro de 2008 em diante, vem unindo pessoas através da boa e única "gelada", além de inovar com um cardápio inigualável, cheio de sabor e cultura.
                                </div>

                            </div>

                        </div>

                    </div>

                </div>

	</c:forEach>

                

            </div>


</div>

<%-- 
        <div class="baseprincipal">
            <div class="corpobase">
				INÍCIO DOS BLOCOS DE ESTABELECIMENTOS
			    <c:set var="seqEst" value="${1}"/>
				<c:forEach items="${estabelecimentos}" var="e" >
			       <c:if test="${e.getGaleriaEst().size() >= 3}">
					        <div class="containerEstabelecimento">
			                    <div class="basecomponentes">
			                    CARREGA AS FOTOS DE FACHADA E LOGOTIPO DO ESTABELECIMENTO
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

 --%> 

</tags:template>
