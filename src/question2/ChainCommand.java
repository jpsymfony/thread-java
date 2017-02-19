package question2;

import question1.Command;

/**
 * Decrivez votre classe CommandToChain ici.
 *
 * @author (votre nom)
 * @version (un numero de version ou une date)
 */
public class ChainCommand<T> implements Command<T>
{
    private Handler<T> chain;

    public ChainCommand(Handler<T> chain)
    {
        this.chain = chain;
    }

    public void make(T value)
    {
        chain.handleRequest(value);
    }
}
