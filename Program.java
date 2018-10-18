import shed.mbed.*;

/**
 * @author Ali
 * @version v1
 */
public class Program
{
    // The object for interacting with the FRDM/MBED.
    private MBed mbed;
    private boolean buttonLeft;
    private boolean buttonRight;
    private int score = 0;
    private int question_no = 0;
    private int total_no_questions = 10;
    private String question = " ";
    private String query; 
    private String[] answers; 
    private String correctAnswer;   


    /**
     * Open a connection to the MBED.
     */
    public Program()
    {
        mbed = MBedUtils.getMBed();
    }

    /**
     * The starting point for the interactions.
     */
    public void run()
    {
        LCD lcd = mbed.getLCD();
        LED board = mbed.getLEDBoard();
        LED shield = mbed.getLEDShield();

        mbed.getJoystickLeft().addListener
        (isPressed -> 
            {
                if(isPressed) 
                {
                    leftButtonPressed();
                }
            }
        );

        mbed.getJoystickRight().addListener
        (isPressed -> 
            {
                if(isPressed) 
                {                    
                    rightButtonPressed();
                }
            }
        );

        mbed.getJoystickFire().addListener
        (isPressed -> 
            {
                if(isPressed) 
                {
                    fireButton();
                }
            }
        );

        while ( buttonLeft == false && buttonRight == false) 
        {
            lcd.print(25, 0, "Welcome to mQuiz!");
            sleep(2000);
            lcd.clear();
            lcd.print(10, 20,"Use the joystick to start:");
        }

        if ( buttonLeft == true || buttonRight == true) 
        {
            quizStart();
        }

        while(mbed.isOpen()) 
        {
            sleep(1000);
        }
    }

    public void leftButtonPressed()
    {
        buttonLeft =  true;
        buttonRight =  false;
    }

    public void rightButtonPressed()
    {
        buttonLeft = false;
        buttonRight =  true;
    }

    public void fireButton()
    {
        LCD lcd = mbed.getLCD();
        LED board = mbed.getLEDBoard();
        LED shield = mbed.getLEDShield();
        if( buttonRight == true ) {
            shield.setColor(LEDColor.RED);
        } else{ 
            shield.setColor(LEDColor.GREEN);
        }

        if( buttonLeft == true ) {
            shield.setColor(LEDColor.GREEN);
        } else{ 
            shield.setColor(LEDColor.RED);
        }
    }

    public void quizStart()
    {
        LCD lcd = mbed.getLCD();
        LED board = mbed.getLEDBoard();
        LED shield = mbed.getLEDShield();
        lcd.clear();
        lcd.print(10, 10, "Get ready, quiz starting!");
        sleep(3000);
        lcd.clear();
        lcd.print(60, 10, "3");
        sleep(1000);
        lcd.print(60, 10, "2");
        sleep(1000);
        lcd.print(60, 10, "1");
        sleep(1000);
        quizQuestions();
    }

    public void quizQuestions()
    {
        LCD lcd = mbed.getLCD();
        LED board = mbed.getLEDBoard();
        LED shield = mbed.getLEDShield();
        lcd.clear();
        buttonLeft = false;
        buttonRight = false;
        question = "A football match is 90 minutes!";
        lcd.print(0, 0, "Q: " + question);
        lcd.print(0, 20, "True");
        lcd.print(100, 20, "False");

        mbed.getJoystickLeft().addListener
        (isPressed -> 
            {
                if(isPressed) 
                {
                    lcd.clear();
                    lcd.print(10, 0, "You have selected: True" );
                    lcd.print(10, 20, " Press fire if correct! " );
                }
            }
        );

        mbed.getJoystickRight().addListener
        (isPressed -> 
            {
                if(isPressed) 
                {                    
                    lcd.clear();
                    lcd.print(10, 0, "You have selected: False" );
                    lcd.print(10, 20, " Press fire if correct! " );
                }
            }
        );

        mbed.getJoystickFire().addListener
        (isPressed -> 
            {
                if(isPressed) 
                {
                    if( buttonRight == true ) {
                        shield.setColor(LEDColor.RED);
                        lcd.clear();
                        lcd.print(10, 0, "Oh no! Wrong answer!" );
                        sleep(3000);
                        shield.setColor(LEDColor.BLACK);
                        run();
                    } else{ 
                        shield.setColor(LEDColor.GREEN);
                    }

                    if( buttonLeft == true ) {
                        shield.setColor(LEDColor.GREEN);
                        lcd.clear();
                        lcd.print(5, 0, "Great! You answered right!" );
                        sleep(3000);
                        lcd.clear();
                        lcd.print(10, 10, "Get ready, next question!");
                        shield.setColor(LEDColor.BLACK);
                        sleep(3000);
                        lcd.clear();
                        lcd.print(60, 10, "3");
                        sleep(1000);
                        lcd.print(60, 10, "2");
                        sleep(1000);
                        lcd.print(60, 10, "1");
                        sleep(1000);
                        quizQuestions2();
                    } else{ 
                        shield.setColor(LEDColor.RED);
                    }
                }
            }
        );
    }
    
    public void quizQuestions2()
    {
        LCD lcd = mbed.getLCD();
        LED board = mbed.getLEDBoard();
        LED shield = mbed.getLEDShield();
        lcd.clear();
        buttonLeft = false;
        buttonRight = false;
        question = "Chao is sexy ;)";
        lcd.print(0, 0, "Q: " + question);
        lcd.print(0, 20, "True");
        lcd.print(100, 20, "False");

        mbed.getJoystickLeft().addListener
        (isPressed -> 
            {
                if(isPressed) 
                {
                    lcd.clear();
                    lcd.print(10, 0, "You have selected: True" );
                    lcd.print(10, 20, " Press fire if correct! " );
                }
            }
        );

        mbed.getJoystickRight().addListener
        (isPressed -> 
            {
                if(isPressed) 
                {                    
                    lcd.clear();
                    lcd.print(10, 0, "You have selected: False" );
                    lcd.print(10, 20, " Press fire if correct! " );
                }
            }
        );

        mbed.getJoystickFire().addListener
        (isPressed -> 
            {
                if(isPressed) 
                {
                    if( buttonRight == true ) {
                        shield.setColor(LEDColor.GREEN);
                        lcd.clear();
                        lcd.print(5, 0, "Great! You answered right!" );
                        sleep(3000);
                        lcd.clear();
                        lcd.print(10, 10, "Get ready, next question!");
                        shield.setColor(LEDColor.BLACK);
                        sleep(3000);
                        lcd.clear();
                        lcd.print(60, 10, "3");
                        sleep(1000);
                        lcd.print(60, 10, "2");
                        sleep(1000);
                        lcd.print(60, 10, "1");
                        sleep(1000);
                    } else{ 
                        shield.setColor(LEDColor.RED);
                    }

                    if( buttonLeft == true ) {
                        shield.setColor(LEDColor.RED);
                        lcd.clear();
                        lcd.print(10, 0, "Oh no! Wrong answer!" );
                        sleep(3000);
                        shield.setColor(LEDColor.BLACK);
                        run();
                    } else{ 
                        shield.setColor(LEDColor.GREEN);
                    }
                }
            }
        );
    }
    

    /**
     * Close the connection to the MBED.
     */
    public void finish()
    {
        mbed.close();
    }

    /**
     * A simple support method for sleeping the program.
     * @param millis The number of milliseconds to sleep for.
     */
    private void sleep(int millis)
    {
        try {
            Thread.sleep(millis);
        } 
        catch (InterruptedException ex) {
            // Nothing we can do.
        }
    }

}
