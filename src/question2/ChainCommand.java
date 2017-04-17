package question2;

import question1.Command;

/**
 * Decrivez votre classe CommandToChain ici.
 *
 * @param <T> the type parameter
 * @author SAULNIER
 * @version 12 -03-2017
 */
public class ChainCommand<T> implements Command<T>
{
    private Handler<T> chain;

    /**
     * Instantiates a new Chain command.
     *
     * @param chain the chain
     */
    public ChainCommand(Handler<T> chain)
    {
        this.chain = chain;
    }

    public void make(T value)
    {
        chain.handleRequest(value);
    }
}
