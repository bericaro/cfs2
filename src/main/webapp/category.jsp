<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>${categoria}</title>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body
	style="background: linear-gradient(to bottom, #ffffff, #5D8AA8); min-height: 100vh;">
	<div
		class="container min-vh-100 d-flex flex-column justify-content-start align-items-center mb-5">

			<div
				class="container min-vh-100 d-flex flex-column justify-content-start align-items-center mb-5">
				<!-- Header -->
				<header class="text-center mt-3 mb-4 p-3 rounded bg-light shadow-sm">
					<img
						src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSD-41mzQSKxgFjq7qawCLiMIGvd8UIDRJkTA&s"
						alt="Logo" class="img-fluid mb-3" style="height: 50px;">
					<h1 class="mt-2 mb-1">StoryFlow</h1>
					<p class="mt-1 text-muted fst-italic">Il tuo compagno per
						scoprire nuove storie e avventure</p>
					<a href="https://www.tuosito.com" target="_blank">Link</a>
				</header>

				<!-- Linea divisoria e titolo principale -->
				<div class="d-flex justify-content-center align-items-center mb-4">
					<div class="w-25">
						<hr class="text-success" style="border-width: 2px;">
					</div>
					<span
						class="fw-bold display-4 text-success d-flex align-items-center">
						<span
						style="font-family: 'Georgia', serif; letter-spacing: 0.1em;">${categoria}</span>
						<i class="fas fa-book-open text-success me-2"></i>
					</span>
				</div>
				<div class="position-absolute top-0 end-0 p-3 d-flex"
					style="flex-direction: row;">
					<!-- Bottone Login -->
					<a href="login.html" class="btn btn-outline-success me-2">Login</a>
					<!-- Bottone Sign Up -->
					<a href="signup.html" class="btn btn-outline-success">SignUp</a>
				</div>

				<!-- Contenitore principale -->
				<div class="container py-5">
					<!-- Bottone Indietro e Barra di Ricerca sulla stessa linea -->
					<div class="d-flex align-items-center justify-content-between">
						<!-- Bottone Indietro -->
						<a href="home.html"
							class="btn btn-outline-success d-inline-flex align-items-center me-3">
							<span class="me-2">&larr;</span>
						</a>

						<!-- Barra di Ricerca -->
						<div class="flex-grow-1 mx-3">
							<input type="text" class="form-control"
								placeholder="Cerca nella libreria..."
								aria-label="Barra di ricerca">
						</div>
					</div>
				</div>
				<c:choose>
					<c:when test="${categoria == 'Manga'}">
						<p>Manga</p>
					</c:when>
					<c:when test="${categoria == 'Libri'}">
						<!-- Griglia delle card -->
						<div class="container">
							<div class="row">
								<!-- Prima Card -->

								<div class="col-lg-3 col-md-4 col-sm-6 mb-3">
									<div class="card h-100 border-0 shadow-sm" type="submit">
										<img
											src="https://movieplayer.net-cdn.it/images/2003/06/08/la-locandina-di-orgoglio-e-pregiudizio-16205.jpg"
											class="card-img-top" alt="Immagine 2"
											style="height: 250px; object-fit: cover;">
										<div class="card-body p-2">
											<div
												class="d-flex justify-content-between align-items-center">
												<h6 class="card-title mb-1">Orgoglio e Pregiudizio</h6>
												<a href="#" class="text-dark" title="Salva"
													onclick="toggleBookmark(this)"> <i
													class="far fa-bookmark fa-lg" id="bookmarkIcon"></i> <!-- Icona vuota iniziale -->
												</a>
											</div>
											<p class="card-text small text-success">Libro</p>
											<div class="star-rating d-flex gap-1">
												<i class="fas fa-star p-2 rounded-circle text-warning"></i>
												<i class="fas fa-star p-2 rounded-circle text-warning"></i>
												<i class="fas fa-star p-2 rounded-circle text-warning"></i>
												<i class=></i> <i class="far fa-star p-2 rounded-circle"></i>
											</div>
										</div>
									</div>
								</div>

								<div class="col-lg-3 col-md-4 col-sm-6 mb-3">
									<div class="card h-100 border-0 shadow-sm" type="submit">
										<img src="https://m.media-amazon.com/images/I/71QxecnTncL.jpg"
											class="card-img-top" alt="Immagine 3"
											style="height: 250px; object-fit: cover;">
										<div class="card-body p-2">
											<div
												class="d-flex justify-content-between align-items-center">
												<h6 class="card-title mb-1">I Terrestri</h6>
												<a href="#" class="text-dark" title="Salva"
													onclick="toggleBookmark(this)"> <i
													class="far fa-bookmark fa-lg" id="bookmarkIcon"></i> <!-- Icona vuota iniziale -->
												</a>
											</div>
											<p class="card-text small text-success">Libro</p>
											<div class="star-rating d-flex gap-1">
												<i class="fas fa-star p-2 rounded-circle text-warning"></i>
												<i class="fas fa-star p-2 rounded-circle text-warning"></i>
												<i class="far fa-star p-2 rounded-circle"></i> <i
													class="far fa-star p-2 rounded-circle"></i> <i
													class="far fa-star p-2 rounded-circle"></i>
											</div>
										</div>
									</div>
								</div>

								<div class="col-lg-3 col-md-4 col-sm-6 mb-3">
									<div class="card h-100 border-0 shadow-sm" type="submit">
										<img
											src="https://www.adelphi.it/spool/i__id8656_mw1000__1x.jpg"
											class="card-img-top" alt="Immagine 4"
											style="height: 250px; object-fit: cover;">
										<div class="card-body p-2">
											<div
												class="d-flex justify-content-between align-items-center">
												<h6 class="card-title mb-1">L'avversario</h6>
												<a href="#" class="text-dark" title="Salva"
													onclick="toggleBookmark(this)"> <i
													class="far fa-bookmark fa-lg" id="bookmarkIcon"></i> <!-- Icona vuota iniziale -->
												</a>
											</div>
											<p class="card-text small text-success">Libro</p>
											<div class="star-rating d-flex gap-1">
												<i class="fas fa-star p-2 rounded-circle text-warning"></i>
												<i class="fas fa-star p-2 rounded-circle text-warning"></i>
												<i class="fas fa-star p-2 rounded-circle text-warning"></i>
												<i class="fas fa-star p-2 rounded-circle text-warning"></i>
												<i class="fas fa-star p-2 rounded-circle text-warning"></i>
											</div>
										</div>
									</div>
								</div>

								<div class="col-lg-3 col-md-4 col-sm-6 mb-3">
									<div class="card h-100 border-0 shadow-sm" type="submit">
										<img
											src="https://m.media-amazon.com/images/I/61vqvF5OcXL._AC_UF1000,1000_QL80_.jpg"
											class="card-img-top" alt="Immagine 5"
											style="height: 250px; object-fit: cover;">
										<div class="card-body p-2">
											<div
												class="d-flex justify-content-between align-items-center">
												<h6 class="card-title mb-1">L'ombra del vento</h6>
												<a href="#" class="text-dark" title="Salva"
													onclick="toggleBookmark(this)"> <i
													class="far fa-bookmark fa-lg" id="bookmarkIcon"></i> <!-- Icona vuota iniziale -->
												</a>
											</div>
											<p class="card-text small text-success">Libro</p>
											<div class="star-rating d-flex gap-1">
												<i class="fas fa-star p-2 rounded-circle text-warning"></i>
												<i class="fas fa-star p-2 rounded-circle text-warning"></i>
												<i class="fas fa-star p-2 rounded-circle text-warning"></i>
												<i class="fas fa-star p-2 rounded-circle text-warning"></i>
												<i class="far fa-star p-2 rounded-circle"></i>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:when>
					<c:when test="${categoria == 'Serie TV'}">
						<p>Latest Entertainment Updates...</p>
					</c:when>
					<c:when test="${categoria == 'Fumetti'}">
						<p>Latest Entertainment Updates...</p>
					</c:when>
				</c:choose>
		</body>
</html>