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
                data-toggle="modal" data-target="#mdlogin">
                <c:if test="${not empty usuarioLog}">
                	Olá ${usuarioLog.nome}
                </c:if>
                
				<c:if test="${empty usuarioLog}">
                login
                </c:if>
                
                </button>

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

		</div>

          <!-- Modal LOGIN -->
          <div class="modal" id="mdlogin">

              <div class="modal-dialog">
                
                <div class="modal-content fmtmodalcontent">
              
                    <div class="modal-body fmtmodalbody">

                      <div class="tright">
                      <button type="button" class="btnLoginFechar" data-dismiss="modal">X</button>
                      </div>

                      <div class="LogoNPassCentro">NigthPass </div>
                      
                          <section id='loginContainer'>

						  <c:url value="/logar" var="action" />
                          <form class="loginContainer" action="${action}" method="POST" commandName="pessoaFisica" id='loginForm'>
                        
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
                        	
                        	<c:url value="/cadastrousuario" var="cadastrousuario" />
                              <span class="Textosimples18">Não possui uma conta?</span>
                              <a href="${cadastrousuario}">Cadastre-se aqui!</a>
                              
                             <input type="button" class="btnLoginEntrar"
                				data-toggle="modal" data-target="#mdloginGestor"
                				value="Gestor entre aqui">
                              
                          </section>
                          
                    </div>
                  
                </div>
              </div>
          </div>
      

          <!-- Modal LOGIN GESTOR-->
          <div class="modal" id="mdloginGestor">

              <div class="modal-dialog">
                
                <div class="modal-content fmtmodalcontent">
              
                    <div class="modal-body fmtmodalbody">

                      <div class="tright">
                      <button type="button" class="btnLoginFechar" data-dismiss="modal">X</button>
                      </div>

                      <div class="LogoNPassCentro">NigthPass (gestor)</div>
                      
                          <section id='loginContainer'>

						  <c:url value="/logarGestor" var="action" />
                          <form class="loginContainer" action="${action}" method="post" commandName="pessoaFisica" id='loginForm'>
                        
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
                        
                          </section>

                    </div>
                  
                </div>
              </div>
          </div>
            
            
      </div>

</tags:template>
