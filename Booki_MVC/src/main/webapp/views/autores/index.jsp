<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="model.Autores"
    import="java.util.List"
%>

<%
@SuppressWarnings("unchecked")
List<Autores> lista = (List<Autores>) request.getAttribute("autores");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="icon" href="./assets/img/book-2-fill.svg" type="image/svg" />
<link rel="stylesheet" href="./assets/css/style.css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
<link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">
<title>Booki | Autores</title>
</head>
<body>
	<main>
		<header class="header">
			<h1>Autores</h1>
		</header>
		
		<ul class="nav justify-content-center">
		  <li class="nav-item">
		    <a class="nav-link active" aria-current="page" href="./index.html">Home</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="./autores">Autores</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="#">Editoras</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="#">Livros</a>
		  </li>
		</ul>
		
		 <section class="container">
		 
	     	<div class="p-4">
			 	<a href="./views/autores/create.html" class="btn btn-primary mb-2 botao1">
		            Novo Autor
		        </a>
				<table class="table table-responsive table-hover">
				  <thead class="thead-dark">
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">Nome</th>
				      <th scope="col">foto</th>
				      <th scope="col">Ações</th>
				    </tr>
				  </thead>
				  <tbody>
		
					<% for (Autores a: lista) { %>
					  	<tr>
					      <td><%=a.getId() %></td>
					      <td><%=a.getNome() %></td>
					      <td>
					      <img src="./assets/img/<%=a.getImagem() %>" width="50px" alt=""/>
					      </td>
					    
					      <td class="d-flex">
	                           <a href="edit?id=<%=a.getId() %>" class="mx-1"
	                           		title="Editar">
	                               <i class="ri-file-edit-line"></i>
	                           </a>
	                           <a href="delet?id=<%=a.getId() %>" class="mx-1"
	                           		title="Cancelar"
	                           		onclick="return confirm('Deseja excluir o autor <%=a.getNome() %>.')">
	                               <i class="ri-delete-bin-2-line"></i>
	                           </a>
	                       </td>
					    </tr>
				  	<% } %>
				  	
				  </tbody>
				</table>
			 </div>
	      </section>
	      
	    </main>
    
	<footer>
		<img
			src="./assets/img/recode.svg"
			alt="recodePro" />
	</footer>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>