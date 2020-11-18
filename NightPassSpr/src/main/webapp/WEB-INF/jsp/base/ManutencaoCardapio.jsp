<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<tags:template
title="NightPass - Principal"
cssProprio="/resources/css/ManutencaoCardapio.css"
jsProprio="/resources/js/CatalogoEst.js">
      
      <div class="baseprincipal">

            <div class="topo">

                <div class="LogoNPass">NigthPass</div>

                <!-- Button to Open the Modal -->

                <button type="button" class="HeadMenuRight">login</button>

            </div>

          <div class="corpo">


          <!-- Button to Open the Modal Inclusão produto -->

		  <span>
          <button type="button" class="btncardapio"
          data-toggle="modal" data-target="#mdNovo">Novo Produto</button>
          </span>


	<c:forEach items="${produtoEstAtu}" var="p">

	<!-- Inicio do bloco de produto -->

	<c:url value="/atualizaproduto/${p.prd_Codigo}" var="action" />

		<form:form modelAttribute="produto" 
		id="produto" action="${action}" method="post">

            <div class='boxproduto'>

              <div class="fotoprod">
              
				<c:if test="${not empty p.getGaleriaProduto()}">
                	<img class="fmtimgprod" src="${p.getGaleriaProduto().get(0).getGap_EndServidor()}">

                </c:if>
                
              </div>
              <div class="dadosprod">
                <div class="fmtdadosprod">
                  Codigo:  <input type="text" style="width: 40%;"
                  value = "${p.prd_Codigo}" name="prd_Codigo"/>
                  Marca: <input type="text" style="width: 40%;"
                  value = "${p.prd_Marca}" name="prd_Marca"/>
                </div>
                <div class="fmtdadosprod">
                  Nome: <input type="text" style="width: 90%;"
                  value = "${p.prd_Nome}" name="prd_Nome"/>
                </div>
                <div class="fmtdadosprod">

                </div>
                <div class="fmtdadosprod">
                  Descrição: <textarea  style="height: 80px; 
                  width: 90%;" name="prd_Descricao">${p.prd_Descricao} </textarea>
                </div>
                <div class="fmtdadosprod">
                  Preço R$:  <input type="text" style="width: 40%;"
                  value = "${p.prd_Preco}" name="prd_Preco"/>
                  Formato: <input type="text" style="width: 40%;"
                  value = "${p.prd_Formato}" name="prd_Formato">
                  
                </div>
              </div>
          </div>
         
          <div style="display: flex">

              <input type="submit" class="btncardapio" value="Salvar Alterações">
              
			<c:url value="/excluirproduto/${p.prd_Codigo}" var="excluirprd"/>
			<a class="btncardapio" href="${excluirprd}">Excluir</a>

		  </div>
		  
	</form:form>	  

			<c:url value="/grafafotoproduto/${p.prd_Codigo}"
					var="modificarFoto" />
			  
				<form action="${modificarFoto}" method="POST"
				enctype="multipart/form-data">

			  	<c:if test="${not empty p.getGaleriaProduto()}">
			  		<input type="hidden" name="gapCodigo" id="gapCodigo"
			  		value="${p.getGaleriaProduto().get(0).getGap_codigo()}">
			  	</c:if>
					<input type="file" onchange="loadFile(event)"
							name="uploadfoto" />
			  		<input type="submit" class="btncardapio" value="Alterar/Incluir Foto">
			  </form>

		<!-- Fim do bloco de produto -->			
	</c:forEach>


          </div>

      </div>


          <div class="modal" id="mdNovo">

              <div>

                
                <div class="modal-content fmtmodalcontent">
              
                    <div class="modal-body fmtmodalbody">
                    
        <c:url value="/incluirproduto" var="action" />

				<form:form modelAttribute="produto" 
					id="produto" action="${action}" method="post" enctype="multipart/form-data">

                      <div class="tright">
                      <button type="button" class="btnLoginFechar" data-dismiss="modal">X</button>
                      </div>
							
					      <div class='boxprodutomd'>
					      
					              <div class="fotoprod">
					              
									<c:if test="${not empty p.getGaleriaProduto()}">
					                	<img class="fmtimgprod" src="${p.getGaleriaProduto().get(0).getGap_EndServidor()}">
					
					                </c:if>
					                
					              </div>
					              <div class="dadosprod">
					                <div class="fmtdadosprod">
					                  Codigo:  <input type="text" style="width: 40%;"
					                  value = "${p.prd_Codigo}"/>
					                  Marca: <input type="text" style="width: 40%;"
					                  value = "${p.prd_Marca}" name="prd_Marca"/>
					                </div>
					                <div class="fmtdadosprod">
					                  Nome: <input type="text" style="width: 90%;"
					                  value = "${p.prd_Nome}" name="prd_Nome"/>
					                </div>
					                <div class="fmtdadosprod">
					
					                </div>
					                <div class="fmtdadosprod">
					                  Descrição: <textarea  style="height: 80px; 
					                  width: 90%;" name="prd_Descricao">${p.prd_Descricao} </textarea>
					                </div>
					                <div class="fmtdadosprod">
					                  Preço R$:  <input type="text" style="width: 40%;"
					                  value = "${p.prd_Preco}" name="prd_Preco"/>
					                  Formato: <input type="text" style="width: 40%;"
					                  value = "${p.prd_Formato}" name="prd_Formato">
					                </div>
					                
					                <div style="margin-left:5px">
					                Foto: 
					                <input style="margin-top: 10px" type="file" onchange="loadFile(event)"
									name="uploadfoto" />
									</div>
					                
					                
					              </div>
					              
					          </div>
					         
					          <div style="display: flex">
					
					              <input type="submit" class="btncardapio" value="Incluir">
					              					
							  </div>
							  
						</form:form>
							 
                    </div>
                  
                </div>
                

                
              </div>
          </div>



</tags:template>
