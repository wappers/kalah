<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>Kalah - Chris Morgan</title>
</head>
<style>
.store {
	height: 256px;
	width: 128px;
	display: block;
}

.player1 {
	border: 1px solid red;
}

.player2 {
	border: 1px solid blue;
}
</style>
<body>
	<h1>Kalah</h1>
	<a href="<c:url value="/newGame" />">New Game</a>
	<table border=1>
		<tr>
			<c:set var="imgNumber" value="${board.player1.store.stones}"
				scope="page"></c:set>
			<c:if test="${imgNumber>24}">
				<c:set var="imgNumber" value="24" />
			</c:if>
			<td class="player1" rowspan=2>Player 1<img class="store"
				src="<c:url value="/images/stones/${imgNumber}.png"/>" />${board.player1.store.stones}
			</td>
			<c:forEach begin="1" end="${board.configHouses}" var="i" step="1">
				<c:set var="j" value="${board.configHouses-i+1}" scope="page"></c:set>
				<c:set var="imgNumber" value="${board.pits[j-1].stones}"
					scope="page"></c:set>
				<c:if test="${imgNumber>24}">
					<c:set var="imgNumber" value="24" />
				</c:if>
				<td class="player1"><a href="<c:url value="/kalah/go/${j}" />"><img
						src="/images/stones/${imgNumber}.png" /></a>${board.pits[j-1].stones}</td>
			</c:forEach>

			<c:set var="imgNumber" value="${board.player2.store.stones}"
				scope="page"></c:set>
			<c:if test="${imgNumber>24}">
				<c:set var="imgNumber" value="24" />
			</c:if>
			<td rowspan=2 class="player2">Player 2<img class="store"
				src="<c:url value="/images/stones/${imgNumber}.png"/>" />${board.player2.store.stones}
			</td>
		</tr>

		<tr>
			<c:forEach begin="1" end="${board.configHouses}" var="i" step="1">
				<c:set var="j" value="${board.configHouses+1+i}" scope="page"></c:set>
				<c:set var="imgNumber" value="${board.pits[j-1].stones}"
					scope="page"></c:set>
				<c:if test="${imgNumber>24}">
					<c:set var="imgNumber" value="24" />
				</c:if>
				<td class="player2"><a href="<c:url value="/kalah/go/${j}" />"><img
						src="/images/stones/${imgNumber}.png" /></a>${board.pits[j-1].stones}</td>
			</c:forEach>

		</tr>
	</table>
	<h2>
		Current player is ${board.currentPlayer}
	</h2>


	<div class="messages">
		<c:forEach var="message" items="${board.messages}">
			<p>${message}</p>
		</c:forEach>
	</div>
<h3>Rules:</h3>
	<OL>
		<LI>The game provides a Kalah board and a number of seeds or
			counters. The board has 12 small pits, called houses, on each side;
			and a big pit, called an end zone, at each end. The object of the
			game is to capture more seeds than one's opponent.
		<LI>At the beginning of the game, four seeds are placed in each
			house. This is the traditional method.
		<LI>Each player controls the six houses and their seeds on the
			player's side of the board. The player's score is the number of seeds
			in the store to their right.
		<LI>Players take turns sowing their seeds. On a turn, the player
			removes all seeds from one of the houses under their control. Moving
			counter-clockwise, the player drops one seed in each house in turn,
			including the player's own store but not their opponent's.
		<LI>If the last sown seed lands in an empty house owned by the
			player, and the opposite house contains seeds, both the last seed and
			the opposite seeds are captured and placed into the player's store.
		<LI>If the last sown seed lands in the player's store, the player
			gets an additional move. There is no limit on the number of moves a
			player can make in their turn.
		<LI>When one player no longer has any seeds in any of their
			houses, the game ends. The other player moves all remaining seeds to
			their store, and the player with the most seeds in their store wins.
		
	</OL>
	It is possible for the game to end in a draw.

</body>
</html>