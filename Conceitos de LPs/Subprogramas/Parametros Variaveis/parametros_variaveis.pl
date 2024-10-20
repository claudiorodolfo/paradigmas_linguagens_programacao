# Perl
use strict;
use warnings;

sub print_numbers {
    my @numbers = @_;
    foreach my $number (@numbers) {
        print "$number\n";
    }
}

# Chama a função com um número variável de parâmetros
print_numbers(1, 2, 3, 4, 5);
