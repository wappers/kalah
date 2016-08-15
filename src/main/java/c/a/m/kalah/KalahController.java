package c.a.m.kalah;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("board")
public class KalahController {
	private final KalahGame game = new KalahGame();

	@RequestMapping(value = "/newGame")
	public final String newGame(ModelMap model) throws Exception {
		model.addAttribute("board", new KalahBoard(6, 6));
		return "kalah";
	}

	@ModelAttribute("board")
	public KalahBoard getInitializeMyObject() {
		return new KalahBoard(6, 6);
	}

	@RequestMapping("/kalah")
	public String welcome(@ModelAttribute("board") KalahBoard board) {
		return "kalah";
	}

	@RequestMapping("/kalah/go/{houseNumber}")
	public String go(@PathVariable int houseNumber, @ModelAttribute("board") KalahBoard board) {
		game.go(board, houseNumber);
		return "redirect:/kalah";
	}

}