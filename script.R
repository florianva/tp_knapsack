# Author : SV
# date 2015/10/12

############################
# recherche alÃ©atoire

# lit les donnÃ©es des recherches alÃ©atoires
df.rs <- read.table("rs.csv", sep = ";")

# vÃ©rification du fichier: affiche les premiÃ¨res lignes
names(df.rs) <- c("nbeval", "fitness")

# histogramme pour un nombre d'Ã©valuation 10000 : nota, la distribution n'est pas gaussienne
hist(df.rs[df.rs$nbeval == 10000,]$fitness)

# calcul de la moyenne
mean(df.rs[df.rs$nbeval == 10000,]$fitness)

# rÃ©sumÃ© des principales statistiques
summary(df.rs[df.rs$nbeval == 10000,]$fitness)

# nuage de points des fitness obtenues en fonction du nombre d'Ã©valuation
plot(fitness ~ nbeval, data = df.rs)

# chargement de la librairie doBy
library(doBy)

# calcul des moyennes de fitness en fonction du nombre d'Ã©valuation
df.rs.mean <- summaryBy(fitness ~ nbeval, data = df.rs)

# plot correspondant
plot(fitness.mean ~ nbeval, data = df.rs.mean)

# grosso modo, on a l'impression que les donnÃ©es suivent une loi logarithmique
# d'ailleur, on peut tracer avec le log:
plot(fitness.mean ~ log(nbeval), data = df.rs.mean)

# et mÃªme fitter un modÃ¨le linÃ©aire
model <- lm(fitness.mean ~ log(nbeval), data = df.rs.mean)

# trace la droite de rÃ©gression
abline(model)
# donne le descriptif du modÃ¨le : noter un trÃ¨s bon coefficient R^2
summary(model)

## Remarque : sans la librairie doBy 

# split des donnÃ©es selon les valeur en ligne (obtient alors une liste)
l <- split(df.rs$fitness, factor(df.rs$nbeval))

# boite a moustache (boxplot) de la fitness en fonction du nombre d'Ã©valuation (attention echelle non respectÃ©e en abscisse)
boxplot(l)

# calcul des moyennes (nota: R est un langage fonctionnel)
l.mean <- lapply(l, FUN = mean)

# et le plot fitness vs. moyenne
plot(names(l.mean), unlist(l.mean))


############################
# marche alÃ©atoire

# lit les donnÃ©es de la marche alÃ©atoire
df.rw <- read.table("rw.csv", sep = ";")

# vÃ©rification du fichier: affiche les premiÃ¨res lignes
names(df.rw) <- c("nbeval", "fitness")

# histogramme des fitness : nota, la distribution n'est pas gaussienne
hist(df.rw$fitness)

# fitness en fonction du nombre d'itÃ©ration. Nota : les variations sont "alÃ©atoires" mais bornÃ©es.
plot(df.rw$fitness)

# calcul de la fonction d'autocorrelation : beaucoup de correlation entre les fitness des solutions voisines
cors <- acf(df.rw$fitness)

# le premier coefficient d'autocorrelation est trÃ¨s proche de 1:
print(cors[1])

