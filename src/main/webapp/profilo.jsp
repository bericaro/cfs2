<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profilo Utente</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
</head>
<body style="background: linear-gradient(to bottom, #ffffff, #5D8AA8); min-height: 100vh;">
    <div class="container min-vh-100 d-flex flex-column justify-content-start align-items-center mb-5">

        <header class="text-center mt-3 mb-4 p-3 rounded bg-light shadow-sm">
            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSD-41mzQSKxgFjq7qawCLiMIGvd8UIDRJkTA&s" 
                 alt="Logo" 
                 class="img-fluid mb-3" 
                 style="height: 50px;">
            <h1 class="mt-2 mb-1">
                StoryFlow
            </h1>
            <p class="mt-1 text-muted fst-italic">Il tuo compagno per scoprire nuove storie e avventure</p>
            <a href="https://www.tuosito.com" target="_blank">Link</a>
        </header>
        
        <div class="position-absolute top-0 end-0 p-3 d-flex" style="flex-direction: row;">
            <!-- Bottone Login -->
            <a href="login.html" class="btn btn-outline-secondary me-2">Login</a>
            <!-- Bottone Sign Up -->
            <a href="signup.html" class="btn btn-outline-secondary">SignUp</a>
        </div>

        <!-- Profilo -->
        <main class="flex-grow-1 overflow-auto">
            <!-- Foto profilo e informazioni -->
            <div class="text-center mb-4">
                <div class="rounded-circle overflow-hidden d-flex justify-content-center align-items-center mx-auto" style="width: 150px; height: 150px;">
                    <img src="https://www.avvenire.it/c/2020/PublishingImages/84ac49c61529468ea911ea24859551f3/Mukhtarova_67789044.jpg?width=1024" alt="Immagine Profilo" class="w-100 h-100" style="object-fit: cover;">
                </div>
                <h2 class="mt-3">${user.email.substring(0, user.email.indexOf('@'))}</h2>
                <p class="text-muted">descrizione</p>
            </div>
            
            <div class="container">
                <div class="d-flex justify-content-center align-items-center mb-4">
                    <h5 class="mb-0">My Library</h5>
                    <button class="btn btn-outline-primary ms-3" data-bs-toggle="modal" data-bs-target="#addCardModal">+</button>
                </div>
                <div class="row">
                    <!-- Card 1 -->
                    <div class="col-lg-3 col-md-4 col-sm-6 mb-3">
                        <div class="card h-100 border-0 shadow-sm">
                            <img src="https://www.animeclick.it/immagini/anime/Kaichou_wa_Maid_sama/cover/Kaichou_wa_Maid_sama-cover.jpg" class="card-img-top" alt="Maid Sama" style="height: 200px; object-fit: cover;">
                            <div class="card-body p-2">
                                <h6 class="card-title mb-1">Maid Sama</h6>
                                <p class="card-text small text-primary">Manga</p>
                                <div class="star-rating d-flex gap-1">
                                    <i class="fas fa-star text-warning"></i>
                                    <i class="fas fa-star text-warning"></i>
                                    <i class="fas fa-star text-warning"></i>
                                    <i class="fas fa-star text-warning"></i>
                                    <i class="far fa-star"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Card 2 -->
                    <div class="col-lg-3 col-md-4 col-sm-6 mb-3">
                        <div class="card h-100 border-0 shadow-sm">
                            <img src="https://movieplayer.net-cdn.it/images/2003/06/08/la-locandina-di-orgoglio-e-pregiudizio-16205.jpg" class="card-img-top" alt="Orgoglio e Pregiudizio" style="height: 200px; object-fit: cover;">
                            <div class="card-body p-2">
                                <h6 class="card-title mb-1">Orgoglio e Pregiudizio</h6>
                                <p class="card-text small text-success">Libro</p>
                                <div class="star-rating d-flex gap-1">
                                    <i class="fas fa-star text-warning"></i>
                                    <i class="fas fa-star text-warning"></i>
                                    <i class="fas fa-star text-warning"></i>
                                    <i class="far fa-star"></i>
                                    <i class="far fa-star"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Card 3 -->
                    <div class="col-lg-3 col-md-4 col-sm-6 mb-3">
                        <div class="card h-100 border-0 shadow-sm">
                            <img src="https://www.ibs.it/images/5051891133969_0_536_0_75.jpg" class="card-img-top" alt="The 100" style="height: 200px; object-fit: cover;">
                            <div class="card-body p-2">
                                <h6 class="card-title mb-1">The 100</h6>
                                <p class="card-text small text-dark">Serie TV</p>
                                <div class="star-rating d-flex gap-1">
                                    <i class="fas fa-star text-warning"></i>
                                    <i class="fas fa-star text-warning"></i>
                                    <i class="far fa-star"></i>
                                    <i class="far fa-star"></i>
                                    <i class="far fa-star"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                   
                </div>
            </div>
        </main>

        <!-- popup -->
        <div class="modal fade" id="addCardModal" tabindex="-1" aria-labelledby="addCardModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="addCardModalLabel">New Obsession</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <!-- Card vuota da compilare -->
                        <div class="card shadow-sm">
                            <img id="cardImagePreview" src="" class="card-img-top" alt="Immagine" style="height: 250px; object-fit: cover;">
                            <div class="card-body">
                                <!-- Form per aggiungere la card -->
                                <form id="cardForm">
                                    <!-- Campo Immagine -->
                                    <div class="mb-3">
                                        <label for="cardImage" class="form-label">Immagine URL</label>
                                        <input type="url" class="form-control" id="cardImage" placeholder="Inserisci URL immagine" required>
                                    </div>
                                    <!-- Campo Titolo -->
                                    <div class="mb-3">
                                        <label for="cardTitle" class="form-label">Titolo</label>
                                        <input type="text" class="form-control" id="cardTitle" placeholder="Inserisci titolo" required>
                                    </div>
                                    <!-- Campo Tipo -->
                                    <div class="mb-3">
                                        <label for="cardType" class="form-label">Tipo</label>
                                        <select class="form-select" id="cardType">
                                            <option value="Serie TV">Serie TV</option>
                                            <option value="Manga">Manga</option>
                                            <option value="Libro">Libro</option>
                                            <option value="Libro">Fumetti</option>
                                        </select>
                                    </div>
                                    <!-- Campo Rating -->
                                    <div class="mb-3">
                                        <label for="cardRating" class="form-label">Rating</label>
                                        <input type="number" class="form-control" id="cardRating" min="1" max="5" value="1" required>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Annulla</button>
                        <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Salva</button>
                    </div>
                </div>
            </div>
            
        </div>
        <div class="mb-5"></div>
        

    </div>
    <nav class="navbar fixed-bottom bg-light border-top">
        <div class="container d-flex justify-content-around">
            <a href="home.html" class="text-muted text-center">
                <i class="fas fa-home fa-2x"></i> <!-- Icona Home -->
                <div>Home</div>
            </a>
            <a href="#" class="text-muted text-center">
                <i class="fas fa-history fa-2x"></i> <!-- Icona Storico -->
                <div>Storico</div>
            </a>
            <a href="profilo.jsp" class="text-muted text-center">
                <i class="fas fa-user fa-2x"></i> <!-- Icona Profilo -->
                <div>Profilo</div>
            </a>
        </div>
    </nav>
</div>

    <!-- JS Bootstrap -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>
</body>
</html>

