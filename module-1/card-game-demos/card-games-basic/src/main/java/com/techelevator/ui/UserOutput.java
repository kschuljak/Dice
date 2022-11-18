package com.techelevator.ui;

import com.techelevator.models.cards.Card;
import com.techelevator.models.hands.FaceCardHand;
import com.techelevator.models.players.Player;
import com.techelevator.models.hands.Hand;
import com.techelevator.ui.constants.ColorCodes;

public class UserOutput
{

    public static void printBlackJackSplashScreen()
    {
        clear();
        System.out.println(ColorCodes.RED);
        System.out.println("?????????????????????????????????????  %  #####################################");
        System.out.println("????????????????????????????????????  %*:  ####################################");
        System.out.println("???????????????????????????????????  %#*?:  ###################################");
        System.out.println("?????????????????????????????????  ,%##*??:.  #################################");
        System.out.println("???????????????????????????????  ,%##*?*#*??:.  ###############################");
        System.out.println("?????????????????????????????  ,%###*??*##*???:.  #############################");
        System.out.println("???????????????????????????  ,%####*???*###*????:.  ###########################");
        System.out.println("?????????????????????????  ,%####**????*####**????:.  #########################");
        System.out.println("???????????????????????  ,%#####**?????*#####**?????:.  #######################");
        System.out.println("??????????????????????  %######**??????*######**??????:  ######################");
        System.out.println("?????????????????????  %######**???????*#######**??????:  #####################");
        System.out.println("????????????????????  %######***???????*#######***??????:  ####################");
        System.out.println("????????????????????  %######***???????*#######***??????:  ####################");
        System.out.println("????????????????????  %######***???????*#######***??????:  ####################");
        System.out.println("?????????????????????  %######**??????***######**??????:  #####################");
        System.out.println("??????????????????????  '%######****:^%*:^%****??????:'  ######################");
        System.out.println("????????????????????????   '%####*:'  %*:  '%*????:'   ########################");
        System.out.println("??????????????????????????           %#*?:           ##########################");
        System.out.println("?????????????????????????????????  ,%##*??:.  #################################");
        System.out.println("???????????????????????????????  .%###***???:.  ###############################");
        System.out.println("??????????????????????????????                   ##############################");
        System.out.println("???????????????????????????????????????*#######################################");
        System.out.println("?????????????????????????????????????? . ######################################");

        System.out.println(ColorCodes.RESET);
    }

    public static void printHeader(String message)
    {
        System.out.println(ColorCodes.YELLOW + "********************" + ColorCodes.RESET);
        System.out.println(ColorCodes.GREEN + message);
        System.out.println(ColorCodes.YELLOW + "********************" + ColorCodes.RESET);
        System.out.println();
    }

	public static void showFaceCardHand(Player player)
	{
        FaceCardHand hand = (FaceCardHand)player.showHand();

        System.out.println();
        System.out.println(ColorCodes.CYAN + "********************" + ColorCodes.RESET);
        System.out.println(ColorCodes.GREEN + "Player: " + player.getName() + ColorCodes.RESET);
        System.out.println(ColorCodes.YELLOW + "Score: " + hand.getValue() + ColorCodes.RESET);

        FaceCardPrinter.printCards(hand.getFaceCards());

        System.out.println(ColorCodes.CYAN + "********************" + ColorCodes.RESET);
        System.out.println();
	}

    public static void showHand(Player player)
    {
        Hand hand = player.showHand();

        System.out.println();
        System.out.println(ColorCodes.CYAN + "********************" + ColorCodes.RESET);
        System.out.println(ColorCodes.GREEN + "Player: " + player.getName() + ColorCodes.RESET);
        System.out.println(ColorCodes.YELLOW + "Score: " + hand.getValue() + ColorCodes.RESET);

        for(Card card : hand.getCards())
        {
            System.out.println(card.getFaceValue() + " of " + card.getColor());
        }

        System.out.println(ColorCodes.CYAN + "********************" + ColorCodes.RESET);
        System.out.println();
    }

	public static void bust(Hand hand)
	{
        System.out.println(ColorCodes.RED + "********************" + ColorCodes.RESET);
        System.out.println(ColorCodes.GREEN + "  You Busted: " + hand.getValue());
        System.out.println(ColorCodes.RED + "********************" + ColorCodes.RESET);

	}

    public static void gameOver()
    {
        clear();
        System.out.println(ColorCodes.RED + "********************" + ColorCodes.RESET);
        System.out.println(ColorCodes.BLUE + "Game Over" );
        System.out.println(ColorCodes.RED + "********************" + ColorCodes.RESET);
    }

	public static void winner(Player player)
	{
        Hand hand = player.showHand();

        System.out.println();
        System.out.println(ColorCodes.YELLOW + "********************" + ColorCodes.RESET);
        System.out.println(ColorCodes.RED + "Winner: " + player.getName() + "!!! " + ColorCodes.CYAN + hand.getValue() + ColorCodes.RESET);
        System.out.println(ColorCodes.YELLOW + "********************" + ColorCodes.RESET);
	}

    public static void thankYou()
    {
        clear();
        System.out.println(ColorCodes.GREEN + "******************************" + ColorCodes.RESET);
        System.out.println(ColorCodes.PURPLE + "Thanks for playing! Come Again");
        System.out.println(ColorCodes.GREEN + "******************************" + ColorCodes.RESET);
    }

    public static void clear()
    {
        final String ANSI_CLS = "\u001b[2J";
        final String ANSI_HOME = "\u001b[H";
        System.out.print(ANSI_CLS + ANSI_HOME);
        System.out.flush();
    }
}