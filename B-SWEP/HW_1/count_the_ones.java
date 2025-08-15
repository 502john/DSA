public static int countOneBits(long val)
{
// Strategy: While Finding Binary Representation Count Ones

int onesCounts = 0;

while( val > 0 )
{
	if ( val % 2 == 1)
	{
onesCounts += 1;
}
val = val / 2;
}

return onesCounts;

}