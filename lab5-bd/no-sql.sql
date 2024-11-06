-- consulta 1: recupera las publicaciones activas más populares y muestra su título y número de “Me gusta”.
db.posts
  .find({ status: "active" }, { title: 1, likes: 1 })
  .sort({ likes: -1 });

-- Optimizacion: crear índices
db.posts.createIndex({ status: 1 });
db.posts.createIndex({ status: 1, likes: -1 });

-- Consulta optimizada seria la misma que la original
db.posts
  .find({ status: "active" }, { title: 1, likes: 1 })
  .sort({ likes: -1 });




-- consulta 2: resuma la cantidad de usuarios activos por ubicación
db.users.aggregate([
  { $match: { status: "active" } },
  { $group: { _id: "$location", totalUsers: { $sum: 1 } } },
]);


-- Optimizacion: crear índices
db.users.createIndex({ status: 1 });
db.users.createIndex({ location: 1 });