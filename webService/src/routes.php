<?php
// Routes

$app->group('/api', function () use ($app) {
  // get all regates
  $app->get('/regates',function ($request, $response, $args) {
       $sth = $this->db->prepare("SELECT * FROM regate");
      $sth->execute();
      $regates = $sth->fetchAll();
      return $this->response->withJson($regates);
  });

  $app->get('/regates/hiver', function ($request, $response, $args) {
         $sth = $this->db->prepare("SELECT * FROM regate r INNER JOIN challenge cha ON r.id_challenge=cha.id_challenge WHERE cha.id_challenge=1 ");
      $sth->execute();
      $regates = $sth->fetchAll();
      return $this->response->withJson($regates);
    });

	$app->get('/regatebyid/[{id}]', function ($request, $response, $args) {
         $sth = $this->db->prepare("SELECT * FROM regate r INNER JOIN commissaire com ON r.id_commissaire=com.id_commissaire INNER JOIN personne per ON com.id_personne=per.id_personne WHERE r.id_regate=:id");
		 $sth->bindParam("id", $args['id']);
        $sth->execute();
        $regatesById = $sth->fetchObject();
        return $this->response->withJson($regatesById);
    });
	
     $app->get('/info/[{id}]', function ($request, $response, $args) {
         $sth = $this->db->prepare("SELECT * FROM regate r INNER JOIN participer par ON r.id_regate=par.id_regate INNER JOIN voilier voi ON par.id_voilier=voi.id_voilier INNER JOIN commissaire com ON r.id_commissaire=com.id_commissaire WHERE r.id_regate=:id");
		 $sth->bindParam("id", $args['id']);
      $sth->execute();
      $regates = $sth->fetchAll();
      return $this->response->withJson($regates);
    });

});
