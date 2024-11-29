package Lab8;

public class IntegrityCheckResult
{
	IntegrityNode node;

	public IntegrityCheckResult(IntegrityNode node)
	{
		this.node = node;
	}

	public IntegrityNode getNode()
	{
		return node;
	}

	public void setNode(IntegrityNode node)
	{
		this.node = node;
	}
	
	public boolean hasPassed()
	{
		return this.node == null;
	}
}
