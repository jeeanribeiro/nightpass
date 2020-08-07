<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<tags:template
title="NightPass - Principal"
cssProprio="/resources/css/CatalogoEst.css"
jsProprio="/resources/js/CatalogoEst.js">

      <div class="baseprincipal">

            <div class="topo">

                <div class="LogoNPass">NigthPass</div>

                <!-- Button to Open the Modal -->

                <button type="button" class="HeadMenuRight"
                data-toggle="modal" data-target="#mdlogin">login</button>

            </div>

		<div class="corpo">


			<!-- Filtro dos Estabelecimentos -->
              <div class="blocobtnFiltro">
                        
                <button type="button" class="btnMenuFiltro" id="btnfiltrar">
                  filtrar
                </button>

                <button type="button" class="btnMenuFiltro" id="btnfiltrar">
                  limpar filtros
                </button>

                <button type="button" class="btnMenuFiltro" id="btnfiltrar">
                  Ok
                </button>


              </div>


			<!-- Dados dos filtros dos Estabelecimentos -->
              <DIV class="fmtFiltro" id="filtroEst">
              
                <div class="blocoFiltro">
                        
                  Toca<br>
                
                  <input type="checkbox" id="t1" name="t1" value="t1">
                  <label for="t1"> Funk</label>
                  <input type="checkbox" id="vehicle2" name="vehicle2" value="Car">
                  <label for="vehicle2"> Sertanejo Universitário</label>
                  <input type="checkbox" id="vehicle3" name="vehicle3" value="Boat">
                  <label for="vehicle3"> Rock</label>
                  <input type="checkbox" id="vehicle3" name="vehicle3" value="Boat">
                  <label for="vehicle3"> Eletrônico</label>
                  <input type="checkbox" id="vehicle3" name="vehicle3" value="Boat">
                  <label for="vehicle3"> Forró</label>
                  <input type="checkbox" id="vehicle3" name="vehicle3" value="Boat">
                  <label for="vehicle3"> Street Dance</label>
                  <input type="checkbox" id="vehicle3" name="vehicle3" value="Boat">
                  <label for="vehicle3"> Anos 80</label>
                  <input type="checkbox" id="vehicle3" name="vehicle3" value="Boat">
                  <label for="vehicle3"> Jazz</label>
                  <input type="checkbox" id="vehicle3" name="vehicle3" value="Boat">
                  <label for="vehicle3"> Latinos</label>
                  <input type="checkbox" id="vehicle3" name="vehicle3" value="Boat">
                  <label for="vehicle3"> Punk Rock</label>

                </div>

                <div class="blocoFiltro">
                        
                  Distância<br>
                
                  <input type="checkbox" id="t1" name="t1" value="t1">
                  <label for="t1">até 2 km</label>
                  <input type="checkbox" id="vehicle2" name="vehicle2" value="Car">
                  <label for="vehicle2"> até 5 km</label>
                  <input type="checkbox" id="vehicle3" name="vehicle3" value="Boat">
                  <label for="vehicle3"> até 10 km</label>
                  <input type="checkbox" id="vehicle3" name="vehicle3" value="Boat">
                  <label for="vehicle3"> até 15 km</label>
                  <input type="checkbox" id="vehicle3" name="vehicle3" value="Boat">
                  <label for="vehicle3"> mais de 15 km</label>

                </div>

                <div class="blocoFiltro">
                        
                  Faixa de Preço(entrada + consumo)<br>
                  <input type="checkbox" id="t1" name="t1" value="t1">
                  <label for="t1">entrada grátis</label>
                  <input type="checkbox" id="t1" name="t1" value="t1">
                  <label for="t1">até R$ 50,0</label>
                  <input type="checkbox" id="vehicle2" name="vehicle2" value="Car">
                  <label for="vehicle2"> até R$ 100,0 </label>
                  <input type="checkbox" id="vehicle3" name="vehicle3" value="Boat">
                  <label for="vehicle3"> até R$ 200,0</label>
                  <input type="checkbox" id="vehicle3" name="vehicle3" value="Boat">
                  <label for="vehicle3"> até R$ 400,0</label>
                  <input type="checkbox" id="vehicle3" name="vehicle3" value="Boat">
                  <label for="vehicle3"> mais de R$ 400,0 </label>

                </div>

              </DIV>


			<!-- Lista de Estabelecimentos -->


        <!-- Variavel de controle da sequencia de fotos -->    
   		<c:set var="idEst" value="1"/>

		<c:forEach items="${estabelecimentos}" var="e">

              <div class="boxEst">
                    
                    <div class="boxFormat">

                        <div class="boxFormat1">
                        
                            <div id="CorroEst${idEst}" class="carousel slide" data-ride="carousel">
                                
                                <!-- Contador das Fotos do Estabelecimento -->
                                <c:set var="idFoto" value="0"/>
                                
                                <!-- Variavel de guarda do active -->
                                <c:set var="active" value="active"/>
                                

								<ol class="carousel-indicators">
	                                <c:forEach items="${e.getGaleriaEst()}" var="g">
										<c:if test="${g.gae_tga_codigo.tgacodigo == 1
											&& not empty g.gae_EndServidor}">
				                                <li data-target="#CorroEst${idEst}" data-slide-to="${idFoto}" class="${active}"></li>
					                            <c:set var="idFoto" value="${idFoto + 1}"/>
					                            <c:set var="active" value=""/>
					                    </c:if>        
		                            </c:forEach>
		                        </ol>
                                
                                <c:set var="active" value="active"/>
                                <div class="carousel-inner">                                
	                                <c:forEach items="${e.getGaleriaEst()}" var="g">
										<c:if test="${g.gae_tga_codigo.tgacodigo == 1
											&& not empty g.gae_EndServidor}">
		                                  <div class="carousel-item ${active}">
		                                    <img src="${g.gae_EndServidor}" class="d-block w-100" alt="${g.gae_EndServidor}">
		                                  </div>
		                                  <c:set var="active" value=""/>
					                    </c:if>
		                            </c:forEach>
                                </div>                                
                                
                                <a class="carousel-control-prev" href="#CorroEst${idEst}" role="button" data-slide="prev">
                                  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                  <span class="sr-only">Previous</span>
                                </a>
                                <a class="carousel-control-next" href="#CorroEst${idEst}" role="button" data-slide="next">
                                  <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                  <span class="sr-only">Next</span>
                                </a>
                            </div>                            
                        
                        </div>

                        <div class="Esp1"> <!--Barra de Separação--></div>

                        <div class="boxFormat3">

                            <div>
                              <div class="DestaqueEst">${e.getPSJ_CODIGO().getPsjNome()}</div>
                            </div>

                            <div class="formatEstInfo">

                              <div>
                              <img class="formatIcon" src="resources/Icones/icons8-mapa-64.png">
                              <span class="Textosimples14"> Distância: 5 km</span>
                              </div>

                              <div>
                              <img class="formatIcon" src="resources/Icones/icons8-música-100.png">
                              <span class="Textosimples14"> Toca: </span>
                              	
                         			<c:forEach items="${e.getGeneroMusical()}" var="gm">
                              			<span class="Textosimples14"> ${gm.getNome()} /</span>
                              		</c:forEach>
                              
                              </div>

                              <div>
                                <img class="formatIcon" src="resources/Icones/icons8-dois-ingressos-64.png">
                                <span class="Textosimples14"> Faixa de Preços: de R$50 a R$ 150</span>
                              </div>

                              <div>
                                <img class="formatIcon" src="resources/Icones/icons8-relógio-128.png">
                                <span class="Textosimples14"> Funcionamento: 23h00 - 06h00 </span>
                              </div>

                              <div>
                                <img class="formatIcon" src="resources/Icones/icons8-festa-dançante-64.png">
                                <span class="Textosimples14"> Estrutura: Area de Bar / Pista de Dança / Show ao vivo</span>
                              </div>

                              <div>
                                <img class="formatIcon" src="resources/Icones/icons8-estrela-64.png">
                                <span class="Textosimples14"> Avaliação: 4,5</span>
                              </div>
                              
                            </div>

                            <div class="btnEst">
                              <span>&nbsp;&nbsp; ==Ingressos, Reservas e Informações clique aqui==&nbsp;&nbsp;</span>
                            </div>


                        </div>
  
                      </div>
                          
              </div>
              
              
              
              
                        <!-- Aumenta a Variavel de controle da sequencia de fotos -->    
                   		<c:set var="idEst" value="${idEst + 1}"/>

		</c:forEach>





              
              <div class="boxEst">
                    
                    <div class="boxFormat">

                        <div class="boxFormat1">
                            
                            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                                <ol class="carousel-indicators">
                                  <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                                  <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                                  <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                                </ol>
                                <div class="carousel-inner">
                                  <div class="carousel-item active">
                                    <img src="the-blue-pub-fachada-1.jpg" class="d-block w-100" alt="...">
                                  </div>
                                  <div class="carousel-item">
                                    <img src="FotoCerveja.jpg" class="d-block w-100" alt="...">
                                  </div>
                                  <div class="carousel-item">
                                    <img src="FotodoShow.jpg" class="d-block w-100" alt="...">
                                  </div>
                                </div>
                                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                                  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                  <span class="sr-only">Previous</span>
                                </a>
                                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                                  <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                  <span class="sr-only">Next</span>
                                </a>
                            </div>                            
                        
                        </div>

                        <div class="Esp1"> <!--Barra de Separação--></div>

                        <div class="boxFormat3">

                            <div>
                              <div class="DestaqueEst"> The Blue Pub</div>
                            </div>

                            <div class="formatEstInfo">

                              <div>
                              <img class="formatIcon" src="Icones\icons8-mapa-64.png">
                              <span class="Textosimples14"> Distância: 5 km</span>
                              </div>

                              <div>
                              <img class="formatIcon" src="Icones\icons8-música-100.png">
                              <span class="Textosimples14"> Toca: Funck / Sertanejo Universitário / Rock  / Jazz / Punk Rock / Samba / Pagode</span>
                              </div>

                              <div>
                                <img class="formatIcon" src="Icones\icons8-dois-ingressos-64.png">
                                <span class="Textosimples14"> Faixa de Preços: de R$50 a R$ 150</span>
                              </div>

                              <div>
                                <img class="formatIcon" src="Icones\icons8-relógio-128.png">
                                <span class="Textosimples14"> Funcionamento: 23h00 - 06h00 </span>
                              </div>

                              <div>
                                <img class="formatIcon" src="Icones\icons8-festa-dançante-64.png">
                                <span class="Textosimples14"> Estrutura: Area de Bar / Pista de Dança / Show ao vivo</span>
                              </div>

                              <div>
                                <img class="formatIcon" src="Icones\icons8-estrela-64.png">
                                <span class="Textosimples14"> Avaliação: 4,5</span>
                              </div>
                              
                            </div>

                            <div class="btnEst">
                              <span>&nbsp;&nbsp; ==Ingressos, Reservas e Informações clique aqui==&nbsp;&nbsp;</span>
                            </div>


                        </div>
  
                      </div>
                          

              </div>

              <div class="boxEst">
                    
                  <div class="boxFormat">

                      <div class="boxFormat1">
                          
                          <div id="carouselExampleIndicators2" class="carousel slide" data-ride="carousel">
                              <ol class="carousel-indicators">
                                <li data-target="#carouselExampleIndicators2" data-slide-to="0" class="active"></li>
                                <li data-target="#carouselExampleIndicators2" data-slide-to="1"></li>
                                <li data-target="#carouselExampleIndicators2" data-slide-to="2"></li>
                                <li data-target="#carouselExampleIndicators2" data-slide-to="3"></li>                                
                              </ol>
                              <div class="carousel-inner">
                                <div class="carousel-item active">
                                  <img src="Loirassa\Fachada1nv.jpg" class="d-block w-100" alt="...">
                                </div>
                                <div class="carousel-item">
                                  <img src="Loirassa\Fachada2nv.jpg" class="d-block w-100" alt="...">
                                </div>
                                <div class="carousel-item">
                                  <img src="Loirassa\Fachada3nv.jpg" class="d-block w-100" alt="...">
                                </div>

                                <div class="carousel-item">
                                  <img src="Loirassa\Fachada3nv.jpg" class="d-block w-100" alt="...">
                                </div>

                              </div>
                              <a class="carousel-control-prev" href="#carouselExampleIndicators2" role="button" data-slide="prev">
                                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                              </a>
                              <a class="carousel-control-next" href="#carouselExampleIndicators2" role="button" data-slide="next">
                                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                              </a>
                          </div>                            
                      
                      </div>

                      <div class="Esp1"> <!--Barra de Separação--></div>

                      <div class="boxFormat3">

                          <div>
                            <div class="DestaqueEst"> Loirassa</div>
                          </div>

                          <div class="formatEstInfo">

                            <div>
                            <img class="formatIcon" src="Icones\icons8-mapa-64.png">
                            <span class="Textosimples14"> Distância: 3,5 km</span>
                            </div>

                            <div>
                            <img class="formatIcon" src="Icones\icons8-música-100.png">
                            <span class="Textosimples14"> Toca: Funck / Sertanejo / Forró / Samba </span>
                            </div>

                            <div>
                              <img class="formatIcon" src="Icones\icons8-dois-ingressos-64.png">
                              <span class="Textosimples14"> Faixa de Preços: de R$20 a R$ 130</span>
                            </div>

                            <div>
                              <img class="formatIcon" src="Icones\icons8-relógio-128.png">
                              <span class="Textosimples14"> Funcionamento: 23h00 - 06h00 </span>
                            </div>

                            <div>
                              <img class="formatIcon" src="Icones\icons8-festa-dançante-64.png">
                              <span class="Textosimples14"> Estrutura: Area de Bar / Pista de Dança / Show ao vivo</span>
                            </div>

                            <div>
                              <img class="formatIcon" src="Icones\icons8-estrela-64.png">
                              <span class="Textosimples14"> Avaliação: 4,5</span>
                            </div>
                            
                          </div>

                          <div class="btnEst">
                            <span>&nbsp;&nbsp; ==Ingressos, Reservas e Informações clique aqui==&nbsp;&nbsp;</span>
                          </div>


                      </div>

                    </div>
                        

              </div>

		</div>

          <!-- Modal LOGIN -->
          <div class="modal" id="mdlogin">

            <form  action="/action_page.php">

              <div class="modal-dialog">
                
                <div class="modal-content fmtmodalcontent">
              
                    <div class="modal-body fmtmodalbody">

                      <div class="tright">
                      <button type="button" class="btnLoginFechar" data-dismiss="modal">X</button>
                      </div>

                      <div class="LogoNPassCentro">NigthPass </div>
                      
                          <section id='loginContainer'>

                          <form action="${action }" method="post" commandName="pessoaFisica" id='loginForm'>
                        
                                <input class="inputlogin"
                                    path="email"
                                        type='text'
                                        name="email"
                                        value='jerson@uol.com'
                                        id='login'
                                        placeholder='E-mail'
                                        pattern='/\d{3}\.\d{3}\.\d{3}\-|[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4})\w+/' />
                              
                                <input class="inputlogin" path="senha" type='password' name="senha"
                                  id='password' placeholder='Senha' minlength='8' value="senhajerson"/>
                              
                                <input class="btnLoginEntrar" type="submit" name="Entrar" value="Entrar">
                              
                                <br>
                                <input style='display:inline-flex' type="checkbox" name="baseimagens" checked>
                                <span style='color:red'>Usar Base Imagens Local Eclipse<br>(para efeito de desenvolvimento)</span>
                        
                            </form>
                        
                              <span class="Textosimples18">Não possui uma conta?</span>
                              <a href="${action}">Cadastre-se aqui!</a>
                              
                              <a href="${action}">Acesso gestor aqui!</a>
                              
                        
                          </section>

                    </div>
    
                  <!-- Modal footer 
                  <div class="cormodal1 modal-footer">
                    <button type="button" class="HeadMenuNormal" data-dismiss="modal">Filtrar</button>
                  </div>
                  -->
                  
                </div>
              </div>
            </form>
          </div>
      
      </div>





























<%--
<div class="baseprincipal">

            <div class="topo">

                <div class="LogoNPass">NigthPass</div>
                <div class="HeadMenuRight">login</div>

            </div>

            <div class="corpo">

				<c:forEach items="${estabelecimentos}" var="e">


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
